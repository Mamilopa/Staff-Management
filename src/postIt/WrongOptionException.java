package postIt;

public class WrongOptionException extends Throwable {

    @Override
    public String toString() {
        return "You picked wrong option";
    }
}
