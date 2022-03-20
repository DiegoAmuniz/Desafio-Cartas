package com.desafiocartas.Desafio.Cartas.controller;

import com.desafiocartas.Desafio.Cartas.feign.FeignCardClient;
import com.desafiocartas.Desafio.Cartas.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {

    //Controller Redireciona as requisições para Classe Service

    @Autowired
    DeckService deckService;

    @GetMapping("/novoBaralho/")
    public ResponseEntity novoBaralho(){
        return new ResponseEntity(deckService.novoBaralho(), HttpStatus.OK);
    }

    @GetMapping("/embaralhar/{deckId}")
    public ResponseEntity embaralharBaralho(@PathVariable("deckId") String deckId){
        return new ResponseEntity(deckService.embaralharDeckId(deckId), HttpStatus.OK);
    }

    @GetMapping("/novoBaralhoEmbaralhado/")
    public ResponseEntity novoBaralhoEmbaralhado(@RequestParam(value = "deck_count", defaultValue = "1") String deckCount){
        return new ResponseEntity(deckService.novoBaralhoEmbaralhado(deckCount),HttpStatus.OK);
    }

    @GetMapping("/parcialBaralho/")
    public ResponseEntity baralhoParcial(@RequestParam ("deck") String deck){
        return new ResponseEntity(deckService.baralhoParcial(deck), HttpStatus.OK);
    }
}
