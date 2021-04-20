package web.ErrorHandling;

public class handleError extends RuntimeException {
    public handleError(String message){
        super(message);
    }
}
