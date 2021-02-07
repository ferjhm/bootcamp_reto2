package bootcamp.springboot.reto2.persistence.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {

    @Id
    Long id;
   // @Column(name = "dni")
    Long dni;
    String nombre;
    String apellido;
    String direccion;
    String distrito;
    String provincia;


}
