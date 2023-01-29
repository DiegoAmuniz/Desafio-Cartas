package com.desafiocartas.Desafio.Cartas.controller;

import com.desafiocartas.Desafio.Cartas.model.Baralho;
import com.desafiocartas.Desafio.Cartas.model.PileName;
import com.desafiocartas.Desafio.Cartas.model.Piles;
import com.desafiocartas.Desafio.Cartas.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping
public class Controller {
    @Autowired
    DeckService deckService;

    @ResponseStatus(OK)
    @GetMapping("/novo")
    public Baralho novo(){
        return deckService.novo();
    }

    @ResponseStatus(OK)
    @GetMapping("{deckId}/embaralhar")
    public Baralho embaralhado(@PathVariable("deckId") String deckId){
        return deckService.embaralhado(deckId);
    }

    @ResponseStatus(OK)
    @GetMapping("/novo/embaralhar")
    public Baralho novoEmbaralhar(@RequestParam(value = "cartas_Contagem", defaultValue = "1") String deckCount){
        return deckService.novoEmbaralhar(deckCount);
    }

    @ResponseStatus(OK)
    @GetMapping("/novo/embaralhar/parcial")
    public Baralho baralhoParcial(@RequestParam ("cartas") String deck){
        return deckService.baralhoParcial(deck);
    }

    @ResponseStatus(OK)
    @GetMapping("{deckId}/desenhar")
    public Baralho desenhar(@PathVariable("deckId") String deckId, @RequestParam(value = "contagem", defaultValue = "2") String count){
        return deckService.desenhar(deckId, count);
    }

    @ResponseStatus(OK)
    @GetMapping("{deckId}/pilha/{pile_name}/listar")
    public Baralho listarPilha(@PathVariable("deckId") String deckId, @PathVariable("pile_name") String piles){
        return deckService.listarPilha(deckId, piles);
    }
}
