package web.ErrorHandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;


@ControllerAdvice  //-> applicable for other controllers also
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    //in this we gonna handle specific exception if given filed/resource is not found
    @ExceptionHandler(handleError.class)
    public ResponseEntity<?> handleResourceNotFoundException (ResourceNotFound exception, WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }

    //advice




    //if there is any exception occur in our project this will be called
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllException (Exception exception,WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(true));
        return  new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetails errorDetails= new ErrorDetails(new Date(),"Validation failed",ex.getBindingResult().getAllErrors().toString());
        return  new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);
    }
}
