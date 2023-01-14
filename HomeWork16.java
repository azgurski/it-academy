import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class HomeWork16 {
    public static void main(String[] args) {
        Database database = new Database();

        List<Writer> writerList = Arrays.asList(
                new Writer(1, database),
                new Writer(2, database),
                new Writer(3, database),
                new Writer(4, database)
        );

        List<Reader> readerList = Arrays.asList(
                new Reader(1, database),
                new Reader(2, database),
                new Reader(3, database),
                new Reader(4, database)
        );

        ExecutorService executorService = Executors.newCachedThreadPool();

        writerList.forEach(executorService::execute);
        readerList.forEach(executorService::execute);

        executorService.shutdown();
    }
}

class Database {
    private final Semaphore readSemaphore = new Semaphore(1, true);
    private final Semaphore writeSemaphore = new Semaphore(1, true);
    private volatile int readersInHall = 0;
    private volatile boolean isAccessible = true;

    public boolean isAccessible() {
        return isAccessible;
    }

    public void setAccessible(boolean accessible) {
        isAccessible = accessible;
    }

    public void read(int readerId) throws InterruptedException {
        readSemaphore.acquire();
        readersInHall++;

        if (readersInHall == 1) {
            writeSemaphore.acquire();
        }
        readSemaphore.release();

        //reading
        System.out.println("Reader " + readerId + " is reading...");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Reader " + readerId + " has finished reading.");

        //releasing
        readSemaphore.acquire();
        readersInHall--;

        if (readersInHall == 0) {
            writeSemaphore.release();
        }
        readSemaphore.release();
    }

    public void write(int writerId) throws InterruptedException {
        writeSemaphore.acquire();

        //writing
        System.out.println("Writer " + writerId + " is writing...");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Writer " + writerId + " has finished writing.");

        writeSemaphore.release();
        setAccessible(false);
    }
}

class Writer implements Runnable {
    private final int writerId;
    private final Database database;

    Writer(int writerId, Database database) {
        this.writerId = writerId;
        this.database = database;
    }

    public int getWriterId() {
        return writerId;
    }

    @Override
    public void run() {
        while (database.isAccessible()) {
            try {
                database.write(getWriterId());
            } catch (InterruptedException ex) {
                String errorMessage = String.format("Writer %s can't get access to read or something went wrong. %s",
                        getWriterId(), ex.getMessage());
                System.out.println(errorMessage);
            }
        }
    }
}

class Reader implements Runnable {
    private final int readerId;
    private final Database database;

    Reader(int readerId, Database database) {
        this.readerId = readerId;
        this.database = database;
    }

    public int getReaderId() {
        return readerId;
    }

    @Override
    public void run() {
        while (database.isAccessible()) {
            try {
                database.read(getReaderId());
            } catch (InterruptedException ex) {
                String errorMessage = String.format("Reader %s can't get access to read or something went wrong. %s",
                        getReaderId(), ex.getMessage());
                System.out.println(errorMessage);
            }
        }
    }
}