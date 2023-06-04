package lab1;

import java.io.Serializable;
import java.io.OutputStream;
import java.io.Writer;

public interface Transport extends Serializable {

    // Геттеры
    int getSpeed();
    String getBrand();
    double getCost();
    int getCapacity();

    // Сеттеры
    void setBrand(String brand);
    void setCost(double cost);
    void setSpeed(int speed) throws InvalidSpeedException;
    void setCapacity(int capacity);

    // Функциональный метод
    double calculateUsefulWork();

    // Лаба 5

    void output(OutputStream out);
    void write(Writer out);
}
