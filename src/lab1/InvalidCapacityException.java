package lab1;

public class InvalidCapacityException extends RuntimeException {
    public InvalidCapacityException(int capacity) {
        super("Capacity cannot be negative! Your capacity = " + capacity);
    }
}