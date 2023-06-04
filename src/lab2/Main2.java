package lab2;

import java.io.*;
import lab1.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        String[] facilities = {"Кожаное кресло", "Кондиционер"};
        Car car = new Car(2200, "Toyota", 5000, 4, facilities);
        FileOutputStream fos = new FileOutputStream("./res/output.txt");
        Tools.serialize(car, fos);
        fos.close();


        FileInputStream fis = new FileInputStream("./res/output.txt");
        Transport car1 = Tools.deserialize(fis);
        System.out.println(car1);
        fis.close();
    }
}
