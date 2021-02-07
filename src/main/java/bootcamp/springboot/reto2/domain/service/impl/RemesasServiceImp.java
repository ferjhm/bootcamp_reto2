package bootcamp.springboot.reto2.domain.service.impl;

import bootcamp.springboot.reto2.domain.dto.ClienteDto;
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

    /*    Mono<RemesasDto> MonoReme = Mono.just(remesasRepository.findById(id)).map(

                p -> {
                    RemesasDto remesasDto = new RemesasDto();
                    BeanUtils.copyProperties(p,remesasDto);
                    return  remesasDto;
                }

        );*/

        Mono<RemesasDto> MonoReme = Mono.just(remesasRepository.findById(id).map(

                p -> {
                    RemesasDto remesasDto = new RemesasDto();
                    BeanUtils.copyProperties(p,remesasDto);
                    return  remesasDto;
                }

        ).get());




        return MonoReme;
    }

    @Override
    public Flux<RemesasDto> obtenerRemesas() {
        return null;
    }
}
