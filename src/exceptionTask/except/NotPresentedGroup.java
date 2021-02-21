package exceptionTask.except;

public class NotPresentedGroup extends RuntimeException{
    public NotPresentedGroup() {
        super();
    }

    public NotPresentedGroup(String message) {
        super(message);
    }

    public NotPresentedGroup(String message, Throwable cause) {
        super(message, cause);
    }

    public NotPresentedGroup(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }
}
