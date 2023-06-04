package lab3;

import lab1.Car;
import lab1.Transport;
import lab1.Truck;

import lab2.Tools;

import java.util.ArrayList;
import java.util.List;

public class FactoryTest {

    public static void main(String[] args) {
        List<Transport> transportList = new ArrayList<>();

        Tools.setFactory(new CarFactory());
        Factory<?> factory = Tools.getFactory();
        Car car = (Car) factory.create();

        Tools.setFactory(new TruckFactory());
        factory = Tools.getFactory();
        Truck truck = (Truck) factory.create();

        transportList.add(car);
        transportList.add(truck);

        truck = Tools.createInstance();
        Tools.setFactory(new CarFactory());
        car = Tools.createInstance();

        transportList.add(car);
        transportList.add(truck);

        for (Transport transport : transportList) {
            System.out.println(transport);
            for (String facilitie : transport) {
                System.out.println(facilitie);
            }
        }

        System.out.println(car.getCost());
        car.setCost(228);
        System.out.println(car.getCost());

    }

}
