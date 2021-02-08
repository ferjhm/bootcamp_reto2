package bootcamp.springboot.reto2.domain.service.impl;

import bootcamp.springboot.reto2.domain.dto.ClienteDto;

import bootcamp.springboot.reto2.domain.service.NotificadorService;
import bootcamp.springboot.reto2.persistence.entities.Cliente;
import bootcamp.springboot.reto2.repositories.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import reactor.core.publisher.*;
import java.util.Comparator;

@Service
public class NotificadorServiceImpl implements NotificadorService {


    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Mono<ClienteDto> obtenerClienteDto(Long id) {

        ClienteDto clienteDto = new ClienteDto();

        BeanUtils.copyProperties( clienteRepository.findById(id).get(),clienteDto);

        return Mono.just(clienteDto);
    }


    @Override
    public Flux<ClienteDto> listarClientesDto() {


        Flux<ClienteDto> fluxCli = Flux.fromIterable(clienteRepository.findAll()).map(

                p -> {
                    ClienteDto clienDto = new ClienteDto();
                    BeanUtils.copyProperties(p,clienDto);
                    return  clienDto;
                }
        ).sort(
                Comparator.comparing(ClienteDto::getDni)
        );
        return fluxCli;


    }

    @Override
    public Mono<ClienteDto> ingresarClientesDto(ClienteDto clienteDto) {

        Cliente cliente = new Cliente();

        BeanUtils.copyProperties(clienteDto, cliente);

        clienteRepository.save(cliente);


        return Mono.just(clienteDto);
    }


}
