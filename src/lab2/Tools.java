package lab2;

import lab1.InvalidSpeedException;
import lab1.Transport;
import lab3.Factory;

import java.io.*;
import java.util.Iterator;

public class Tools {

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

    // lab 6

    public static  <T extends Transport> UnmodifiableTransportDecorator<T> unmodifiable(T obj) {
        return new UnmodifiableTransportDecorator<T>(obj);
    }
    public static class UnmodifiableTransportDecorator<T extends Transport> implements Transport {
        private final T obj;

        public UnmodifiableTransportDecorator(T obj){
            this.obj = obj;
        }

        @Override
        public int getSpeed() {
            return obj.getSpeed();
        }

        public String info() {
            return obj.toString();
        }

        @Override
        public String getBrand() {
            return obj.getBrand();
        }

        @Override
        public double getCost() {
            return obj.getCost();
        }

        @Override
        public int getCapacity() {
            return obj.getCapacity();
        }

        @Override
        public void setBrand(String brand) {
            throw new UnsupportedOperationException("Object is unmodifiable");
        }

        @Override
        public void setCost(double cost) {
            throw new UnsupportedOperationException("Object is unmodifiable");
        }

        @Override
        public void setSpeed(int speed) throws InvalidSpeedException {
            throw new UnsupportedOperationException("Object is unmodifiable");
        }

        @Override
        public void setCapacity(int capacity) {
            throw new UnsupportedOperationException("Object is unmodifiable");
        }

        @Override
        public double calculateUsefulWork() {
            return obj.calculateUsefulWork();
        }

        @Override
        public void output(OutputStream out) {
            obj.output(out);
        }

        @Override
        public void write(Writer out) {
            obj.write(out);
        }

        @Override
        public Iterator<String> iterator() {
            return obj.iterator();
        }
    }

    private static Factory<?> factory;

    public static void setFactory(Factory<?> factory) {
        Tools.factory = factory;
    }

    public static Factory<?> getFactory() {
        return Tools.factory;
    }

    public static <T> T createInstance() {
        return (T) factory.create();
    }
}

