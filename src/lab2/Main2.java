package lab2;

import java.io.*;
import lab1.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        Car car = new Car(200, "Toyota", 5000, 4);
        FileOutputStream fos = new FileOutputStream("./res/output.txt");
        IOUtils.serialize(car, fos);
        fos.close();
    }
}
