package lab1;

import lab2.IOUtils;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

import java.util.Objects;

public class Car implements Transport {

    private int speed;
    private String brand;
    private double cost;
    private int capacity;


    // Конструкторы
    public Car() {
        this.speed = 300;
        this.brand = "MOAIS";
        this.cost = 4_345_000;
        this.capacity = 250;
    }

    public Car(int speed, String brand, double cost, int capacity) {
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

    public double calculateCostPerSpeed() {
        return cost / speed;
    }

    // Переопределение методов Object
    @Override
    public String toString() {
        return "lab1.Car{" +
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
        Car car = (Car) object;
        return speed == car.speed &&
                Double.compare(car.cost, cost) == 0 &&
                capacity == car.capacity &&
                Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed, brand, cost, capacity);
    }


    //Лаба 5

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
