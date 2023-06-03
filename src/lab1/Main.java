package lab1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Transport> transportList = new ArrayList<>();

        // Добавляем объекты автомобилей и грузовиков в массив транспортов
        transportList.add(new Car(270, "Honda", 20000, 5));
        transportList.add(new Truck(70, "Volvo", 50000, 10000));
        transportList.add(new Car(225, "Toyota", 25000, 6));
        transportList.add(new Truck(60, "Mercedes", 80000, 12000));
        transportList.add(new Car(340, "Audi", 80000, 2));
        transportList.add(new Truck(50, "Scania", 90000, 12500));

        // Выводим полную информацию обо всех объектах в массив
        for (Transport transport : transportList) {
            System.out.println(transport);
        }

        // Находим объекты с одинаковой полезной работой и помещаем их в новый массив
        ArrayList<Transport> equalTransportList = new ArrayList<>();
        for (int i = 0; i < transportList.size(); i++) {
            for (int j = i + 1; j < transportList.size(); j++) {

                if (transportList.get(i).calculateUsefulWork() == transportList.get(j).calculateUsefulWork()) {
                    if (!equalTransportList.contains(transportList.get(i))) {
                        equalTransportList.add(transportList.get(i));
                    }
                    if (!equalTransportList.contains(transportList.get(j))) {
                        equalTransportList.add(transportList.get(j));
                    }
                }
            }
            System.out.println(transportList.get(i).calculateUsefulWork());
        }

        // Выводим полную информацию обо всех объектах equalTransportList
        for (Transport transport : equalTransportList) {
            System.out.println(transport.toString());
        }

        // Создаем два массива для хранения объектов lab1.Car и lab1.Truck соответственно
        ArrayList<Car> carList = new ArrayList<>();
        ArrayList<Truck> truckList = new ArrayList<>();

        // Разбиваем исходный массив на два массива, в которых будут храниться однотипные элементы
        for (Transport transport : transportList) {
            if (transport instanceof Car) {
                carList.add((Car) transport);
            } else {
                truckList.add((Truck) transport);
            }
        }

        // Выводим lab1.Car
        for (Car car : carList) {
            System.out.println(car);
        }

        // Выводим lab1.Truck
        for (Truck truck : truckList) {
            System.out.println(truck);
        }

        Car car = new Car();
        try {
            car.setSpeed(-10);
        } catch (InvalidSpeedException error) {
            System.out.println("Error: " + error.getMessage());
        }

//        car.setCapacity(-100);

    }
}
