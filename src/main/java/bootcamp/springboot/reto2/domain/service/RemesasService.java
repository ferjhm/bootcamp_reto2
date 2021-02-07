package bootcamp.springboot.reto2.domain.service;

import bootcamp.springboot.reto2.domain.dto.ClienteDto;
import bootcamp.springboot.reto2.domain.dto.RemesasDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface RemesasService {

    public Mono<RemesasDto> listarRemesa(Long id);

    public Flux<RemesasDto> obtenerRemesas();
}
