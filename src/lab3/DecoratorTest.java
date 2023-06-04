package lab3;

import lab1.Car;
import lab1.Transport;
import lab1.Truck;

import lab2.Tools;

import java.util.ArrayList;
import java.util.List;

public class DecoratorTest {

    public static void main(String[] args) {
        List<Transport> transportList = new ArrayList<>();
        String[] facilities = {"Кожаное кресло", "Кондиционер"};

        Car car = new Car(2200, "Toyota", 5000, 4, facilities);
        Truck truck = new Truck(2, "To", 50, 4, facilities);

        Tools.UnmodifiableTransportDecorator<Car> newCar = Tools.unmodifiable(car);
        Tools.UnmodifiableTransportDecorator<Truck> newTruck = Tools.unmodifiable(truck);


        transportList.add(newCar);
        transportList.add(newTruck);

        for (Transport transport : transportList) {
            System.out.println(transport);
            for (String facilitie : transport) {
                System.out.println(facilitie);
            }
        }

        System.out.println(newCar.getCost());
        newCar.setCost(228);
        System.out.println(newCar.getCost());

    }

}
