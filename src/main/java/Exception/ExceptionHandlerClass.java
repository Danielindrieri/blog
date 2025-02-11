package Exception;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerClass.class);

    @ExceptionHandler(value = EntityNotFoundException.class)
    protected ResponseEntity<Error> entityNotFound(EntityNotFoundException ex) {
        logger.error("Entity not found: {}", ex.getMessage());
        Error error = new Error();
        error.setMessage("The requested entity was not found");
        error.setDetails(ex.getMessage());
        error.setStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EntityExistsException.class)
    protected ResponseEntity<Error> alreadyExistsException(EntityExistsException ex) {
        logger.error("Entity already exists: {}", ex.getMessage());
        Error error = new Error();
        error.setMessage("The entity already exists");
        error.setDetails(ex.getMessage());
        error.setStatus(String.valueOf(HttpStatus.CONFLICT.value()));
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Error> handleGenericException(Exception ex) {
        logger.error("An unexpected error occurred: {}", ex.getMessage());
        Error error = new Error();
        error.setMessage("An unexpected error occurred");
        error.setDetails(ex.getMessage());
        error.setStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
