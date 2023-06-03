package lab1;

import lab2.IOUtils;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

import java.util.Objects;

public class Truck implements Transport {

    private int speed;
    private String brand;
    private double cost;
    private int capacity;


    // Конструкторы
    public Truck() {
        this.speed = 80;
        this.brand = "Volvo";
        this.cost = 1_000_000;
        this.capacity = 5000;
    }

    public Truck(int speed, String brand, double cost, int capacity) {
        this.speed = speed;
        this.brand = brand;
        this.cost = cost;
        this.capacity = capacity;
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
        return "lab1.Truck{" +
                "speed = " + speed +
                "km/h, brand = " + brand +
                ", cost = " + cost +
                ", capacity = " + capacity +
                "t}";
        }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Truck truck = (Truck) object;
        return speed == truck.speed &&
                Double.compare(truck.cost, cost) == 0 &&
                capacity == truck.capacity &&
                Objects.equals(brand, truck.brand);
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

}
