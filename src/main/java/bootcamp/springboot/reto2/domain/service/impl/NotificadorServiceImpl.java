package bootcamp.springboot.reto2.domain.service.impl;

import bootcamp.springboot.reto2.domain.dto.ClienteDto;
import bootcamp.springboot.reto2.domain.service.NotificadorService;
import bootcamp.springboot.reto2.persistence.entities.Cliente;
import bootcamp.springboot.reto2.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@Service
public class NotificadorServiceImpl implements NotificadorService {


    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente obtenerCliente(Integer id) {
        return null;
    }

    @Override
    public List<ClienteDto> obtenerClientes() {

        List<ClienteDto> clienteDtos = new ArrayList<ClienteDto>();

        for (Cliente c1 : clienteRepository.findAll()) {

            ClienteDto clDto = new ClienteDto();

            BeanUtils.copyProperties(c1,clDto);

            clienteDtos.add(clDto);

        }

        List<Cliente> clienteList = clienteRepository.findAll();


        ClienteDto clDto = new ClienteDto();

        /*
        for (int i=0; i< clienteList.size(); i++){



            BeanUtils.copyProperties(clienteList.get(i),clDto);

            clienteDtos.add(clDto);

        }
        */

        return clienteDtos;
    }

    @Override
    public Flux<Cliente> listarClientes() {


        Flux<Cliente> fluxCli = Flux.fromIterable(clienteRepository.findAll());



      /* Flux<ClienteDto> fluxDto = Flux.defer( () -> Flux.
               fromIterable(clienteRepository.findAll().stream().
                       map(p -> (
                               ClienteDto clienDto = new ClienteDto();
                               BeanUtils.copyProperties(clienDto,clDto));

        ));*/

       /* ClienteDto clDto = new ClienteDto();

        Flux<ClienteDto> FlixCliDto = Flux.fromIterable(clienteRepository.findAll()).map(
                p -> (
                        BeanUtils.copyProperties(p,clDto),
                clDto;
                        )



        );*/


        //Collections.sort

        //clienteRepository.findAll().map( p -> new ClienteDto() );

        //BeanUtils.copyProperties();


        //return clienteRepository.findAll().stream().map(p -> BeanUtils.copyProperties(c1,clDto) );

        //return FlixCli;

        return fluxCli;
    }


    @Override
    public Flux<ClienteDto> listarClientesDto() {

        Flux<ClienteDto> fluxCli = Flux.fromIterable(clienteRepository.findAll()).map(

                p -> {
                    ClienteDto clienDto = new ClienteDto();
                    BeanUtils.copyProperties(p,clienDto);
                    return  clienDto;
                }
        ).filter(p -> p.getDni()>12000000).sort(
                Comparator.comparing(ClienteDto::getDni).reversed()
        );
        return fluxCli;
    }





}
