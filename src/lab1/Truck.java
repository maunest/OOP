package lab1;

import java.io.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class Truck implements Transport {

    private int speed;
    private String brand;
    private double cost;
    private int capacity;

    private String[] facilities;

    // массив удобств


    // Конструкторы
    public Truck() {
        this.speed = 80;
        this.brand = "Volvo";
        this.cost = 1_000_000;
        this.capacity = 5000;
        this.facilities = new String[]{"Кожаное кресло", "Кондиционер"};
    }

    public Truck(int speed, String brand, double cost, int capacity, String[] facilities) {
        this.speed = speed;
        this.brand = brand;
        this.cost = cost;
        this.capacity = capacity;
        this.facilities = facilities;
    }

    // Геттеры
    public int getSpeed() {

        return speed;
    }

    public String getBrand() {
        return brand;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    // Сеттеры
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // Объявляемое исключение
    public void setSpeed(int speed) throws InvalidSpeedException {
        if (speed < 0) {
            throw new InvalidSpeedException(speed);
        }
        this.speed = speed;
    }

    // Необъявляемое исключение
    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new InvalidCapacityException(capacity);
        }
        this.capacity = capacity;
    }

    // Функциональный метод
    public double calculateUsefulWork() {
        return (double) capacity * speed;
    }

    public double calculateCostPerWeight() {
        return cost / capacity;
    }

    // Переопределение методов Object
    @Override
    public String toString() {
        return "Truck{" +
                "speed = " + speed +
                "km/h, brand = " + brand +
                ", cost = " + cost +
                ", capacity = " + capacity +
                "t + facilities = " + Arrays.toString(facilities) + "}";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Truck truck = (Truck) object;
        return speed == truck.speed &&
                Double.compare(truck.cost, cost) == 0 &&
                capacity == truck.capacity &&
                Objects.equals(brand, truck.brand) && Arrays.equals(facilities, truck.facilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed, brand, cost, capacity);
    }



    // Лаба 5

    @Override
    public void output(OutputStream out) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(out);
            dataOutputStream.writeInt(speed);
            dataOutputStream.writeUTF(brand);
            dataOutputStream.writeDouble(cost);
            dataOutputStream.writeInt(capacity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(Writer out) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(out);
            bufferedWriter.write(speed + " " + brand + " " + cost + " " + capacity);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ;ab6

    @Override
    public Iterator<String> iterator() {
        return new FacilitiesIterator(facilities);
    }

    private static class FacilitiesIterator implements Iterator<String> {
        private int currentIndex = 0;
        private String[] facilities;

        public FacilitiesIterator(String[] facilities) {
            this.facilities = facilities;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < facilities.length;
        }

        @Override
        public String next() {
            return facilities[currentIndex++];
        }
    }
}
