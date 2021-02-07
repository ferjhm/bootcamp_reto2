package bootcamp.springboot.reto2.web.controller;

import bootcamp.springboot.reto2.domain.dto.ClienteDto;
import bootcamp.springboot.reto2.domain.dto.RemesasDto;
import bootcamp.springboot.reto2.domain.service.NotificadorService;
import bootcamp.springboot.reto2.domain.service.RemesasService;
import bootcamp.springboot.reto2.persistence.entities.Cliente;
import bootcamp.springboot.reto2.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/notificator")
public class NotificadorController {

    @Autowired
    ClienteRepository clienteRepository;


    @Autowired
    NotificadorService notificadorService;

    @Autowired
    RemesasService remesasService;

    @GetMapping("/")
    public String HolaMundo(){
        return "Hola mundo";
    }

    @GetMapping("/{id}")
    public Cliente obtenerCliente(@PathVariable("id") String id){

        //clienteRepository.findById(1);

        return clienteRepository.findById(Integer.parseInt(id)).get();
    }

    @GetMapping("/allClient")
    public List<ClienteDto> obtenerClientes(){


        return notificadorService.obtenerClientes();
    }

/*
    @GetMapping("/allRemesas")
    public List<ClienteDto> obtenerRemesas(){


        return remesasService.obtenerRemesas();
    }
*/


    @GetMapping("/todos")
    public Flux<Cliente> listarClientes(){

        return notificadorService.listarClientes();
    }

    @GetMapping("/todosDto")
    public Flux<ClienteDto> listarClientesDto(){

        return notificadorService.listarClientesDto();
    }


    @GetMapping("/remesas/{id}")
    public Mono<RemesasDto> alertarRemesa(@PathVariable ("id") Long id){

        return remesasService.listarRemesa(id);
    }


/*

    @PostMapping
    public void enviarData(){

    }

    @GetMapping
    public Remesas getRemesa(){
        return null
    }
*/

}
