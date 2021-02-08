package bootcamp.springboot.reto2.domain.service;

import bootcamp.springboot.reto2.domain.dto.ClienteDto;
import bootcamp.springboot.reto2.persistence.entities.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface NotificadorService {


    public Mono<ClienteDto> obtenerClienteDto(Long id);

    public Flux<ClienteDto> listarClientesDto();

    public Mono<ClienteDto> ingresarClientesDto( ClienteDto clienteDto);


}
