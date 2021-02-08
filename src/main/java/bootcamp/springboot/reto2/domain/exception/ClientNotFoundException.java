package bootcamp.springboot.reto2.domain.exception;

import java.text.MessageFormat;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(Long id){

        super (MessageFormat.format("Usuario con el id: {0} no existe ", id));

    }

}
