package bootcamp.springboot.reto2.domain.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class RemesasDto  {
/*
    @Id
    Long id;

    // @Column(name = "dni")
    Long idRemesa;
    Long dniDestinatario;
    Double Monto;
    String moneda;
    String descripcin;
    Long dniRemitente;
*/


    Long id;
    Double monto;
    String moneda;
    String descripcion;
    Long dniDestinatario;
    Long dniRemitente;


}
