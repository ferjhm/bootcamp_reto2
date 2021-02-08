package bootcamp.springboot.reto2.web.controller;

import bootcamp.springboot.reto2.domain.dto.ClienteDto;
import bootcamp.springboot.reto2.domain.dto.RemesasDto;
import bootcamp.springboot.reto2.domain.service.NotificadorService;
import bootcamp.springboot.reto2.domain.service.RemesasService;
import bootcamp.springboot.reto2.persistence.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/notificator")
public class NotificadorController extends BaseController{

    @Autowired
    NotificadorService notificadorService;

    @Autowired
    RemesasService remesasService;


    @GetMapping("/allClients")
    public ResponseEntity listarClientesDto(){

        return buildSuccessResponse( notificadorService.listarClientesDto());
    }



    @GetMapping("/client/{id}")
    public ResponseEntity obtenerClienteDto(@PathVariable ("id") Long id){

        return buildSuccessResponse( notificadorService.obtenerClienteDto(id));
    }


    @PostMapping("/newClient")
    @ResponseStatus(value= HttpStatus.CREATED)
    public ResponseEntity nuevoClientesDto(@RequestBody ClienteDto clienteDto){

        return buildSuccessResponse(notificadorService.ingresarClientesDto(clienteDto));
    }


    @GetMapping("/allRemesas")
    public ResponseEntity listarRemesasDto(){

        return buildSuccessResponse(remesasService.listarRemesasDto());
    }


    @GetMapping("/remesas/{id}")
    public ResponseEntity alertarRemesa(@PathVariable ("id") Long id){

        return buildSuccessResponse(remesasService.listarRemesa(id));
    }

}
