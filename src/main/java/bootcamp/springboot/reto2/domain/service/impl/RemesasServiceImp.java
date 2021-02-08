package bootcamp.springboot.reto2.domain.service.impl;

import bootcamp.springboot.reto2.domain.dto.RemesasDto;
import bootcamp.springboot.reto2.domain.service.RemesasService;
import bootcamp.springboot.reto2.repositories.RemesasRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class RemesasServiceImp implements RemesasService {


    @Autowired
    RemesasRepository remesasRepository;


    @Override
    public Mono<RemesasDto> listarRemesa(Long id) {


        Mono<RemesasDto> monoReme = Mono.just(remesasRepository.findById(id).map(

                p -> {
                    RemesasDto remesasDto = new RemesasDto();
                    BeanUtils.copyProperties(p,remesasDto);
                    return  remesasDto;
                }

        ).get());

        return monoReme;
    }

    @Override
    public Flux<RemesasDto> listarRemesasDto() {

        Flux<RemesasDto> remesasDtoFlux = Flux.fromIterable(remesasRepository.findAll()).map(

                p -> {
                    RemesasDto remesasDto = new RemesasDto();
                    BeanUtils.copyProperties(p,remesasDto);
                    return  remesasDto;
                }
        );

        return remesasDtoFlux;
    }
}
