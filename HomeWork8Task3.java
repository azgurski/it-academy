public class HomeWork8Task3 {
    public static void main(String[] args) {
        Minibus minibus = new Minibus("Minibus", 24, 7, 50);
        minibus.transporting();

        Citybus citybus = new Citybus("Citybus", 105, 30, 220);
        citybus.transporting();

        Intercitybus intercitybus = new Intercitybus("Intercitybus", 80, 26, 150);
        intercitybus.transporting();

        Electrobus electrobus = new Electrobus("Electrobus", 85, 0, 185);
        electrobus.transporting();

        final Depot depot = new Depot(4);
        depot.addBus(minibus);
        depot.addBus(citybus);
        depot.addBus(intercitybus);
        depot.addBus(electrobus);

        depot.showBusesOfDepot();
        depot.showPriceOfDepot();
        depot.findByPax(70, 30, 255);
        depot.sortByFuel();
    }
}

abstract class Bus {
    private final String type;
    private final int paxCapacity; // Pax - сокращение от Passengers
    private final int fuelConsumption;
    private final int price;

    public Bus(String type, int paxCapacity, int fuelConsumption, int price) {
        this.type = type;
        this.paxCapacity = paxCapacity;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
    }

    public abstract void transporting();

    public String getType() {
        return type;
    }

    public int getPaxCapacity() {
        return paxCapacity;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getPrice() {
        return price;
    }
}

class Depot {
    private final Bus[] buses;

    private int currentElement;

    Depot(final int numberOfBuses) {
        this.buses = new Bus[numberOfBuses];
        this.currentElement = 0;
    }

    public boolean addBus(final Bus bus) {
        if (currentElement >= buses.length) {
            return false;
        }

        buses[currentElement] = bus;
        currentElement++;
        return true;
    }

    public void showBusesOfDepot() {
        System.out.println("\nDepot consists of:");

        for (Bus busFromDepot : buses) {
            System.out.println(busFromDepot.getType());
        }
    }

    public void showPriceOfDepot() {
        int depotPrice = 0;

        for (Bus busFromDepot : buses) {
            depotPrice += busFromDepot.getPrice();
        }

        System.out.println("\nCost of depot is " + depotPrice + "k BYN.");
    }

    public Bus[] findByPax(final int paxToCheck, final int fuelToCheck, final int priceToCheck) {
        final Bus[] foundBuses = new Bus[buses.length];
        int counterOfBuses = 0;
        int foundBusIndex = 0;
        System.out.println("\nAt your request, to find a bus which will carry " + paxToCheck + " passengers, "
                + "which consumes no more than " + fuelToCheck + " l of fuel per 100 km, "
                + "which costs no more than " + priceToCheck + "k BYN:");

        for (Bus busOfDepot : buses) {
            boolean conditionsToCheck = (paxToCheck <= busOfDepot.getPaxCapacity())
                    && (busOfDepot.getFuelConsumption() <= fuelToCheck)
                    && (busOfDepot.getPrice() <= priceToCheck);

            if (conditionsToCheck) {
                for (Bus busToAdd : foundBuses) {
                    foundBuses[foundBusIndex] = busOfDepot;
                }

                System.out.println(busOfDepot.getType() + " will be good your request.");
            }

            counterOfBuses++;
        }

        /* т.к. найденные автобусы складывались в foundBuses[] начиная с 0-го элемента, то в случае отсутствия
        автобусов, удовлетворяющих критериям поиска, в 0-й элемент массива ничего не добавится, и, проведя проверку
        по этому элементу, можно вывести сообщение об отсутствии удовлетворяющих автобусов.*/

        if (foundBuses[0] == null) {
            System.out.println("Unfortunately, we don't have any suitable transport.");
        }

        return foundBuses;
    }

    public Bus[] sortByFuel() {
        final Bus[] sortedBuses = buses.clone();

        for (int currentBusIndex = 0; currentBusIndex < sortedBuses.length; currentBusIndex++) {
            Bus currentMinBus = sortedBuses[currentBusIndex];
            int minFuelBusIndex = currentBusIndex;

            for (int nextCurrentBusIndex = currentBusIndex + 1;
                 nextCurrentBusIndex < sortedBuses.length; nextCurrentBusIndex++) {
                Bus nextBus = sortedBuses[nextCurrentBusIndex];

                if (currentMinBus.getFuelConsumption() > nextBus.getFuelConsumption()) {
                    minFuelBusIndex = nextCurrentBusIndex;
                    currentMinBus = nextBus;
                }
            }

            if (minFuelBusIndex != currentBusIndex) {
                Bus busMin = sortedBuses[minFuelBusIndex];
                Bus busMax = sortedBuses[currentBusIndex];

                sortedBuses[currentBusIndex] = busMin;
                sortedBuses[minFuelBusIndex] = busMax;
            }
        }

        System.out.println("\nSorting buses by Fuel Consumption:");
        for (Bus busOfDepot : sortedBuses) {
            System.out.println(busOfDepot.getType() + ", fuel = " + busOfDepot.getFuelConsumption());
        }

        return sortedBuses;
    }
}

class Minibus extends Bus {

    Minibus(String type, int paxCapacity, int fuelConsumption, int price) {
        super(type, paxCapacity, fuelConsumption, price);
    }

    @Override
    public void transporting() {
        System.out.println("Bus type: " + getType() +
                ", passenger's capacity: " + getPaxCapacity() +
                ", consumption of fuel per 100 km: " + getFuelConsumption() +
                ", price: " + getPrice() + "k BYN.");
    }
}

class Citybus extends Bus {

    public Citybus(String type, int paxCapacity, int fuelConsumption, int price) {
        super(type, paxCapacity, fuelConsumption, price);
    }

    @Override
    public void transporting() {
        System.out.println("Bus type: " + getType() +
                ", passenger's capacity: " + getPaxCapacity() +
                ", consumption of fuel per 100 km: " + getFuelConsumption() +
                ", price: " + getPrice() + "k BYN.");
    }
}

class Intercitybus extends Bus {

    Intercitybus(String type, int paxCapacity, int fuelConsumption, int price) {
        super(type, paxCapacity, fuelConsumption, price);
    }

    @Override
    public void transporting() {
        System.out.println("Bus type: " + getType() +
                ", passenger's capacity: " + getPaxCapacity() +
                ", consumption of fuel per 100 km: " + getFuelConsumption() +
                ", price: " + getPrice() + "k BYN.");
    }
}

class Electrobus extends Bus {
    Electrobus(String type, int paxCapacity, int fuelConsumption, int price) {
        super(type, paxCapacity, fuelConsumption, price);
    }

    @Override
    public void transporting() {
        System.out.println("Bus type: " + getType() +
                ", passenger's capacity: " + getPaxCapacity() +
                ", consumption of fuel per 100 km: " + getFuelConsumption() +
                ", price: " + getPrice() + "k BYN.");
    }
}