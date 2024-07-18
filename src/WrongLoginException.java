public class WrongLoginException extends Exception{

    public WrongLoginException() {
    }

    public WrongLoginException(String message) {
        super(message);
    }

    public WrongLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
