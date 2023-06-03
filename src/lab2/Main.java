package lab2;

import lab1.*;

import java.io.*;


public class Main {
    public static void main(String[] args) {
        Car car = new Car(200, "Toyota", 5000, 4);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Запись объекта в байтовый поток
        IOUtils.output(car, outputStream);

        // Чтение объекта из байтового потока
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        Car carCopy = IOUtils.input(Car.class, inputStream);
        System.out.println(carCopy);

        // Запись объекта в символьный поток
        StringWriter stringWriter = new StringWriter();
        IOUtils.write(car, stringWriter);

        // Чтение объекта из символьного потока
        StringReader stringReader = new StringReader(stringWriter.toString());
        Car carCopy2 = IOUtils.read(Car.class, stringReader);
        System.out.println(carCopy2);
    }
}

