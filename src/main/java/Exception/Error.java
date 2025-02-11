package Exception;

import lombok.Data;

//senza questa classe non funziona ExceptionHandler
@Data
public class Error {
    private String message;
    private String details;
    private String status;
}