package bootcamp.springboot.reto2.persistence.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "remesas")
public class Remesas {

    @Id
    Long id;
    Double monto;
    String moneda;
    String descripcion;
    @Column(name = "dni_destinatario")
    Long dniDestinatario;
    @Column(name = "dni_remitente")
    Long dniRemitente;

}
