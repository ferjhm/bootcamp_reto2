package bootcamp.springboot.reto2.domain.service;

import bootcamp.springboot.reto2.domain.dto.ClienteDto;
import bootcamp.springboot.reto2.persistence.entities.Cliente;
import reactor.core.publisher.Flux;

import java.util.List;

public interface NotificadorService {


    public Cliente obtenerCliente(Integer id);

    public List<ClienteDto> obtenerClientes();

    public Flux<Cliente> listarClientes();

    public Flux<ClienteDto> listarClientesDto();

}
