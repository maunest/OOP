package lab3;

import lab1.Truck;

public class TruckFactory implements Factory<Truck>{
    @Override
    public Truck create() {
        return new Truck();
    }
}