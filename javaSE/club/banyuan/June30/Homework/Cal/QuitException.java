package club.banyuan.June30.Homework.Cal;

public class QuitException extends CalculatorException{
    public QuitException() {
    }

    public QuitException(String message) {
        super(message);
    }

    public QuitException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuitException(Throwable cause) {
        super(cause);
    }

    public QuitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
