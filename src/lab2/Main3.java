package lab2;

import lab1.Transport;
import java.io.FileInputStream;
import java.io.IOException;

public class Main3 {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("./res/output.txt");
        Transport car1 = IOUtils.deserialize(fis);
        System.out.println(car1);
        fis.close();

    }
}
