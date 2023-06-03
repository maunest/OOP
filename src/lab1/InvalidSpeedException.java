package lab1;

public class InvalidSpeedException extends Exception {
    public InvalidSpeedException(int speed) {
        super("Speed cannot be negative! Your speed = " + speed);
    }
}