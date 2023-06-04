package lab2;

import lab1.Car;
import lab1.Truck;
import lab1.Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    static String[] facilities = {"Кожаное кресло", "Кондиционер"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Transport> transportList = new ArrayList<>();

        while (true) {
            System.out.println("Выберите тип элемента (1 - Car, 2 - Truck, 0 - Завершить ввод):");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            Transport transport = null;
            if (choice == 1) {
                transport = createCar(scanner);
            } else if (choice == 2) {
                transport = createTruck(scanner);
            }

            if (transport != null) {
                transportList.add(transport);
            }
        }

        for (Transport transport : transportList) {
            System.out.println(transport);
        }
    }

    private static Car createCar(Scanner scanner) {
        System.out.println("Введите параметры автомобиля:");

        System.out.print("Скорость (км/ч): ");
        int speed = scanner.nextInt();

        System.out.print("Марка: ");
        String brand = scanner.next();

        System.out.print("Цена: ");
        double cost = scanner.nextDouble();

        System.out.print("Грузоподъемность: ");
        int capacity = scanner.nextInt();

        return new Car(speed, brand, cost, capacity, facilities);
    }

    private static Truck createTruck(Scanner scanner) {
        System.out.println("Введите параметры грузовика:");

        System.out.print("Скорость (км/ч): ");
        int speed = scanner.nextInt();

        System.out.print("Марка: ");
        String brand = scanner.next();

        System.out.print("Цена: ");
        double cost = scanner.nextDouble();

        System.out.print("Грузоподъемность: ");
        int capacity = scanner.nextInt();

        return new Truck(speed, brand, cost, capacity, facilities);
    }
}
