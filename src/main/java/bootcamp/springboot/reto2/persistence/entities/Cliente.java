package bootcamp.springboot.reto2.persistence.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
   // @Column(name = "dni")
    Long dni;
    String nombre;
    String apellido;
    String direccion;
    String distrito;
    String provincia;
    String necesidad;
    String argumento;


}
