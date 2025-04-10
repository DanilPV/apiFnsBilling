package ru.company.apiBilling.classesError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllers {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<MessageResponseError> Exception(RestException e) {

        return ResponseEntity
                .status(e.getHttpStatus())
                .body(new MessageResponseError(e.getMessage()));

    }


}
