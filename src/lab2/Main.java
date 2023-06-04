package lab2;

import lab1.*;

import java.io.*;


public class Main {
    public static void main(String[] args) {
        String[] facilities = {"Кожаное кресло", "Кондиционер"};
        Car car = new Car(200, "Toyota", 5000, 4, facilities);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Запись объекта в байтовый поток
        Tools.output(car, outputStream);

        // Чтение объекта из байтового потока
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        Car carCopy = Tools.input(Car.class, inputStream);
        System.out.println(carCopy);

        // Запись объекта в символьный поток
        StringWriter stringWriter = new StringWriter();
        Tools.write(car, stringWriter);

        // Чтение объекта из символьного потока
        StringReader stringReader = new StringReader(stringWriter.toString());
        Car carCopy2 = Tools.read(Car.class, stringReader);
        System.out.println(carCopy2);
    }
}

