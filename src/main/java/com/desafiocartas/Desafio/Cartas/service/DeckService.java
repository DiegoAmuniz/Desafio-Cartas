package com.desafiocartas.Desafio.Cartas.service;

import com.desafiocartas.Desafio.Cartas.feign.FeignCardClient;
import com.desafiocartas.Desafio.Cartas.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeckService {

    @Autowired
    FeignCardClient feignCardClient;

    public Baralho novo(){
        Deck deck = feignCardClient.newDeck();
        Baralho baralho = new Baralho();
        baralho.setSucesso(this.booleanToString(deck.getSuccess()));
        baralho.setBaralho_id(deck.getDeck_id());
        baralho.setEmbaralhado(this.booleanToString(deck.getShuffled()));
        baralho.setRestante(deck.getRemaining());
        return baralho;
}

    public Baralho embaralhado(String id){
        Deck deckEmbaralhar = feignCardClient.shuffleDeckById(id);
        Baralho embaralhar = new Baralho();
        embaralhar.setSucesso(this.booleanToString(deckEmbaralhar.getSuccess()));
        embaralhar.setBaralho_id(deckEmbaralhar.getDeck_id());
        embaralhar.setRestante(deckEmbaralhar.getRemaining());
        embaralhar.setEmbaralhado(this.booleanToString(deckEmbaralhar.getShuffled()));
        return embaralhar;
}

    public Baralho novoEmbaralhar(String deckCount){
        Deck deckNovoEmbaralhar = feignCardClient.newDeckShuffle(deckCount);
        Baralho novoEmbaralhar = new Baralho();
        novoEmbaralhar.setSucesso(this.booleanToString(deckNovoEmbaralhar.getSuccess()));
        novoEmbaralhar.setBaralho_id(deckNovoEmbaralhar.getDeck_id());
        novoEmbaralhar.setEmbaralhado(this.booleanToString(deckNovoEmbaralhar.getShuffled()));
        novoEmbaralhar.setRestante(deckNovoEmbaralhar.getRemaining());
        return novoEmbaralhar;
    }

    public Baralho baralhoParcial(String deck){
        Deck deckParcial = feignCardClient.parcialDeck(deck);
        Baralho parcial = new Baralho();
        parcial.setSucesso(this.booleanToString(deckParcial.getSuccess()));
        parcial.setBaralho_id(deckParcial.getDeck_id());
        parcial.setRestante(deckParcial.getRemaining());
        parcial.setEmbaralhado(this.booleanToString(deckParcial.getShuffled()));
        return parcial;
    }

    public Baralho desenhar(String deckId, String count){
        Deck desenharDeck = feignCardClient.drawDeck(deckId, count);
        Baralho desenhar = new Baralho();
        desenhar.setSucesso(this.booleanToString(desenharDeck.getSuccess()));
        desenhar.setBaralho_id(desenharDeck.getDeck_id());
        List<Carta> cartas = new ArrayList<>();
                for (int i = 0; i < desenharDeck.getCards().size(); i++) {
                    Card card = desenharDeck.getCards().get(i);
                    Carta carta = this.converterCarta(card);
                    cartas.add(carta);
                }
                desenhar.setCartas(cartas);
                desenhar.setRestante(desenharDeck.getRemaining());
                return desenhar;

    }

    public String converteNipe(Card card) {
        switch (card.getSuit()) {
            case "SPADES":
                card.setSuit(SuitType.SPADES.getSuitName());
                break;
            case "HEARTS":
                card.setSuit(SuitType.HEARTS.getSuitName());
                break;
            case "CLUBS":
                card.setSuit(SuitType.CLUBS.getSuitName());
                break;
            case "DIAMONDS":
                card.setSuit(SuitType.DIAMONDS.getSuitName());
                break;
        }
        return card.getSuit();
    }

    public String converteValor(Card card){
        switch (card.getValue()) {
            case "JACK":
                card.setValue(ValueType.JACK.getValueName());
                break;
            case "QUEEN":
                card.setValue(ValueType.QUEEN.getValueName());
                break;
            case "KING":
                card.setValue(ValueType.KING.getValueName());
                break;
            case "ACE":
                card.setValue(ValueType.ACE.getValueName());
                break;
            default: card.setValue(card.getValue());
                break;
        }
        return card.getValue();
    }

    private Carta converterCarta(Card card){
        Carta convCartas = new Carta();
        convCartas.setCodigo(card.getCode());
        convCartas.setImagen(card.getImage());
        convCartas.setTipo(converteNipe(card));
        convCartas.setValor(converteValor(card));
        return convCartas;
    }



    private String booleanToString(Boolean valor){
        if (valor) {
            return "verdadeiro";
        }
        return "falso";
    }

}
