package com.desafiocartas.Desafio.Cartas.controller;

import com.desafiocartas.Desafio.Cartas.feign.FeignCardClient;
import com.desafiocartas.Desafio.Cartas.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {

    //Controller Redireciona as requisições para Classe Service

    @Autowired
    DeckService deckService;

    @GetMapping("/novo/")
    public ResponseEntity novo(){
        return new ResponseEntity(deckService.novo(), HttpStatus.OK);
    }

    @GetMapping("{deckId}/embaralhar/")
    public ResponseEntity embaralhar(@PathVariable("deckId") String deckId){
        return new ResponseEntity(deckService.embaralhado(deckId), HttpStatus.OK);
    }

    @GetMapping("/novo/embaralhar/")
    public ResponseEntity novoEmbaralhar(@RequestParam(value = "cartas_Contagem", defaultValue = "1") String deckCount){
        return new ResponseEntity(deckService.novoEmbaralhar(deckCount),HttpStatus.OK);
    }

    @GetMapping("/novo/embaralhar/parcial")
    public ResponseEntity baralhoParcial(@RequestParam ("cartas") String deck){
        return new ResponseEntity(deckService.baralhoParcial(deck), HttpStatus.OK);
    }

    @GetMapping("{deckId}/desenhar/")
    public ResponseEntity desenhar(@PathVariable("deckId") String deckId, @RequestParam(value = "contagem", defaultValue = "2") String count){
        return new ResponseEntity(deckService.desenhar(deckId, count), HttpStatus.OK);
    }



}
