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
        baralho.setBaralho_id(deck.getDeck_id());
        baralho.setEmbaralhado(deck.getShuffled());
        baralho.setRestante(deck.getRemaining());
        return baralho;
}

    public Baralho embaralharDeckId(String id){
        Deck deckEmbaralhado = feignCardClient.shuffleDeckById(id);
        Baralho embaralhado = new Baralho();
        embaralhado.setSucesso(deckEmbaralhado.getSuccess());
        embaralhado.setBaralho_id(deckEmbaralhado.getDeck_id());
        embaralhado.setRestante(deckEmbaralhado.getRemaining());
        embaralhado.setEmbaralhado(deckEmbaralhado.getShuffled());
        return embaralhado;
}

    public Baralho novoBaralhoEmbaralhado (String deckCount){
        Deck deckNovoEmbaralhado = feignCardClient.newDeckShuffle(deckCount);
        Baralho novoEmbaralhado = new Baralho();
        novoEmbaralhado.setSucesso(deckNovoEmbaralhado.getSuccess());
        novoEmbaralhado.setBaralho_id(deckNovoEmbaralhado.getDeck_id());
        novoEmbaralhado.setEmbaralhado(deckNovoEmbaralhado.getShuffled());
        novoEmbaralhado.setRestante(deckNovoEmbaralhado.getRemaining());
        return novoEmbaralhado;
    }

    public Baralho baralhoParcial(String deck){
        Deck deckParcial = feignCardClient.parcialDeck(deck);
        Baralho parcial = new Baralho();
        parcial.setSucesso(deckParcial.getSuccess());
        parcial.setBaralho_id(deckParcial.getDeck_id());
        parcial.setRestante(deckParcial.getRemaining());
        parcial.setEmbaralhado(deckParcial.getShuffled());
        return parcial;
    }


}
