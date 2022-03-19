package com.desafiocartas.Desafio.Cartas.service;


import com.desafiocartas.Desafio.Cartas.feign.FeignCardClient;
import com.desafiocartas.Desafio.Cartas.model.Baralho;
import com.desafiocartas.Desafio.Cartas.model.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeckService {

    @Autowired
    FeignCardClient feignCardClient;

    public Baralho novoBaralho(){
        Deck deck = feignCardClient.newDeck();
        Baralho baralho = new Baralho();
        baralho.setSucesso(deck.getSuccess());
        baralho.setBaralho_id(deck.getDeck_id();
        baralho.setEmbaralhado(deck.getShuffled();
        baralho.setRestante(deck.getRemaining();
        return baralho;
}

    public Baralho embaralharDeckId(String id){
        Deck deckEmbaralhado = feignCardClient.shuffleDeckById(id);
        Baralho baralhoEmbaralhado = new Baralho();
        baralhoEmbaralhado.setSucesso(deckEmbaralhado.getSuccess();
        baralhoEmbaralhado.setBaralho_id(deckEmbaralhado.getDeck_id();
        baralhoEmbaralhado.setRestante(deckEmbaralhado.getRemaining();
        baralhoEmbaralhado.setEmbaralhado(deckEmbaralhado.getShuffled();
        return baralhoEmbaralhado;
}