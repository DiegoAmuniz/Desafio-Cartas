package com.desafiocartas.Desafio.Cartas.controller;

import com.desafiocartas.Desafio.Cartas.model.Baralho;
import com.desafiocartas.Desafio.Cartas.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class Controller {
    @Autowired
    DeckService deckService;

    @GetMapping("/novo/")
    public ResponseEntity novo(){
        return new ResponseEntity(deckService.novo(), HttpStatus.OK);
    }

    @GetMapping("{deckId}/embaralhar/")
    public ResponseEntity<Baralho> embaralharBaralho(@PathVariable("deckId") String deckId){
        Baralho embaralhar = deckService.embaralhado(deckId);

        return embaralhar != null ? ResponseEntity.ok().body(embaralhar) : ResponseEntity.notFound().build();
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

    @GetMapping("{deckId}/pilha/{pile_name}/listar/")
    public ResponseEntity listarPilha(@PathVariable Map<String, String> patchVarsMap){
        String deck_id = patchVarsMap.get("deckId");
        String piles = patchVarsMap.get("pile_name");
        return new ResponseEntity(deckService.listarPilha(deck_id, piles), HttpStatus.OK);
    }


}
