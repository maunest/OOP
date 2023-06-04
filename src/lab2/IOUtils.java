package lab2;

import lab1.Transport;
import java.io.*;

public class IOUtils {

    public static <T extends Transport> void output(T obj, OutputStream out) {
        obj.output(out);
    }

    public static <T extends Transport> T input(Class<T> clazz, InputStream in) {
        try {
            DataInputStream dataInputStream = new DataInputStream(in);
            int speed = dataInputStream.readInt();
            String brand = dataInputStream.readUTF();
            double cost = dataInputStream.readDouble();
            int capacity = dataInputStream.readInt();
            return clazz.getConstructor(int.class, String.class, double.class, int.class)
                    .newInstance(speed, brand, cost, capacity);
        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T extends Transport> void write(T obj, Writer out) {
        obj.write(out);
    }

    public static <T extends Transport> T read(Class<T> clazz, Reader in) {
        try {
            BufferedReader bufferedReader = new BufferedReader(in);
            String line = bufferedReader.readLine();
            String[] parts = line.split(" ");
            int speed = Integer.parseInt(parts[0]);
            String brand = parts[1];
            double cost = Double.parseDouble(parts[2]);
            int capacity = Integer.parseInt(parts[3]);
            return clazz.getConstructor(int.class, String.class, double.class, int.class)
                    .newInstance(speed, brand, cost, capacity);
        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T extends Transport> void serialize(T obj, OutputStream out) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(out)) {
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T extends Transport> T deserialize(InputStream in) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(in)) {
            return (T) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

