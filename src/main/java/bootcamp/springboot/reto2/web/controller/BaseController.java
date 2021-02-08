package bootcamp.springboot.reto2.web.controller;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class BaseController {

    public <T> ResponseEntity buildSuccessResponse(Flux<T> list){
        return ResponseEntity.accepted().body(list);
    }

    public <T> ResponseEntity buildSuccessResponse(Mono<T> element){
        return  ResponseEntity.accepted().body(element);

    }

    public <T>ResponseEntity buildSuccessResponse(){
        return ResponseEntity.accepted().build();
    }


    public <T>ResponseEntity buildErrorResponse(){
        return ResponseEntity.notFound().build();
    }




}
