package edu.eci.ieti.ecimanager.advice;

import edu.eci.ieti.ecimanager.exception.TuitionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TuitionNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String tuitionNotFoundHandler(TuitionNotFoundException exception){
        return exception.getMessage();
    }

}
