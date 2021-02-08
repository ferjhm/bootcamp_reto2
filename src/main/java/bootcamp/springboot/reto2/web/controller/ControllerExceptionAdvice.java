package bootcamp.springboot.reto2.web.controller;

import bootcamp.springboot.reto2.domain.dto.ErrorResponse;
import bootcamp.springboot.reto2.domain.exception.ClientNotFoundException;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse error(NoSuchElementException ex) {
        return new ErrorResponse(1, "Elemento no encontrado en los registros");
    }

    @ExceptionHandler(value = DecodingException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse error(DecodingException ex) {
        return new ErrorResponse(1, "Error en formato de ingreso de elementos");
    }

}
