import java.util.Scanner;

public class HomeWork3Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите день, месяц и год через Enter");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        boolean checkDay = (day >= 1 && day <= 31);
        boolean checkMonth = (month >= 1 && month <= 12);
        boolean checkYear = (year > 0);
        boolean checkLeapYear = ((year > 0) && (year % 4 == 0));    // проверка года на високосность.

        if (checkDay && checkMonth && checkYear) {
            switch (month) {
                case 1:
                    if (day <= 30) {
                        System.out.println(++day + " января " + year);
                    } else if (day == 31) {
                        System.out.println("1 февраля " + year);
                    }
                    break;
                case 2:
                    if ((day >= 1) && (day <= 27)) {
                        System.out.println(++day + " февраля " + year);
                    } else if ((day == 28 && !checkLeapYear) || (day == 29 && checkLeapYear)) {     // 28 февраля невисокосного или 29 февраля високосного года.
                        System.out.println("1 марта " + year);
                    } else if ((day == 28) && checkLeapYear) {                                      // 28 февраля високосного года.
                        System.out.println("29 февраля " + year + ", потому что год високосный.");
                    } else if (((day > 28) && !checkLeapYear) || ((day > 29) && checkLeapYear)) {
                        System.out.println("Ошибка. В феврале " + year + " года не существует указанный день.");
                    }
                    break;
                case 3:
                    if (day <= 30) {
                        System.out.println(++day + " марта " + year);
                    } else if (day == 31) {
                        System.out.println("1 апреля " + year);
                    }
                    break;
                case 4:
                    if (day <= 29) {
                        System.out.println(++day + " апреля " + year);
                    } else if (day == 30) {
                        System.out.println("1 мая " + year);
                    }
                    break;
                case 5:
                    if (day <= 30) {
                        System.out.println(++day + " мая " + year);
                    } else if (day == 31) {
                        System.out.println("1 июня " + year);
                    }
                    break;
                case 6:
                    if (day <= 29) {
                        System.out.println(++day + " июня " + year);
                    } else if (day == 30) {
                        System.out.println("1 июля " + year);
                    }
                    break;
                case 7:
                    if (day <= 30) {
                        System.out.println(++day + " июля " + year);
                    } else if (day == 31) {
                        System.out.println("1 августа " + year);
                    }
                    break;
                case 8:
                    if (day <= 30) {
                        System.out.println(++day + " августа " + year);
                    } else if (day == 31) {
                        System.out.println("1 сентября " + year);
                    }
                    break;
                case 9:
                    if (day <= 29) {
                        System.out.println(++day + " сентября " + year);
                    } else if (day == 30) {
                        System.out.println("1 октября " + year);
                    }
                    break;
                case 10:
                    if (day <= 30) {
                        System.out.println(++day + " октября " + year);
                    } else if (day == 31) {
                        System.out.println("1 ноября " + year);
                    }
                    break;
                case 11:
                    if (day <= 29) {
                        System.out.println(++day + " ноября " + year);
                    } else if (day == 30) {
                        System.out.println("1 декабря " + year);
                    }
                    break;
                case 12:
                    if (day <= 30) {
                        System.out.println(++day + " декабря " + year);
                    } else if (day == 31) {
                        System.out.println("1 января " + ++year);
                    }
                    break;
            }
        }

        if (!checkDay && checkMonth && checkYear) {
            System.out.println("Число, обозначающее день, введено неверно.");
        } else if (checkDay && !checkMonth && checkYear) {
            System.out.println("Число, обозначающее месяц, введено неверно.");
        } else if (checkDay && checkMonth && !checkYear) {
            System.out.println("Число, обозначающее год, введено неверно.");
        } else if (!checkDay && !checkMonth && checkYear) {
            System.out.println("Числа, обозначающие день и месяц, введены неверно.");
        } else if (!checkDay && checkMonth && !checkYear) {
            System.out.println("Числа, обозначающие день и год, введены неверно.");
        } else if (checkDay && !checkMonth && !checkYear) {
            System.out.println("Числа, обозначающие месяц и год, введены неверно.");
        } else if (!checkDay && !checkMonth && !checkYear) {
            System.out.println("Числа, обозначающие день, месяц и год, введены неверно.");
        }

        scanner.close();
    }
}