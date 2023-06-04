package lab3;

import lab1.Car;

public class CarFactory implements Factory<Car>{
    @Override
    public Car create() {
        return new Car();
    }
}
