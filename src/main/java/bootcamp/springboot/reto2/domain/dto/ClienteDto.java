package bootcamp.springboot.reto2.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteDto  {

    Long id;
    Long dni;
    String nombre;
    String apellido;
    String direccion;
    String distrito;
    String provincia;
    String necesidad;
    String argumento;


}
