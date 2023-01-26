package com.desafiocartas.Desafio.Cartas.service;
import com.desafiocartas.Desafio.Cartas.feign.FeignCardClient;
import com.desafiocartas.Desafio.Cartas.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DeckService {

    @Autowired
    FeignCardClient feignCardClient;

    public Baralho novo(){
        Deck deck = feignCardClient.newDeck();
        Baralho baralho = new Baralho();
        baralho.setSucesso(this.booleanToString(deck.getSuccess()));
        baralho.setBaralho_id(deck.getDeck_id());
        baralho.setRestante(deck.getRemaining());
        baralho.setEmbaralhado(this.booleanToString(deck.getShuffled()));
        return baralho;
    }

    public Baralho embaralhado(String id){
        Deck deckEmbaralhado = feignCardClient.shuffleDeckById(id);
        Baralho embaralhado = new Baralho();
        embaralhado.setSucesso(this.booleanToString(deckEmbaralhado.getSuccess()));
        embaralhado.setBaralho_id(deckEmbaralhado.getDeck_id());
        embaralhado.setRestante(deckEmbaralhado.getRemaining());
        embaralhado.setEmbaralhado(this.booleanToString(deckEmbaralhado.getShuffled()));
        return embaralhado;

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
        ArrayList<Cartas> carta = new ArrayList<>();
                for (int i = 0; i < desenharDeck.getCards().size(); i++) {
                    Cards card = desenharDeck.getCards().get(i);
                    Cartas cartas = this.converterCarta(card);
                    cartas.add(cartas);
                }
                desenhar.setCartas(carta);
                desenhar.setRestante(desenharDeck.getRemaining());
                return desenhar;
    }
    public String converteNipe(Cards card) {
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

    public String converteValor(Cards card){
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

    private Cartas converterCarta(Cards card){
        Cartas convCartas = new Cartas();
        convCartas.setCodigo(card.getCode());
        convCartas.setImagem(card.getImage());
        convCartas.setTipo(converteNipe(card));
        convCartas.setValor(converteValor(card));
        return convCartas;
    }

    private Pilhas converterPilha(Piles piles) {
        Pilhas convPilha = new Pilhas();
        convPilha.setPilhaNome(this.converterPilhaNome(piles.getPileName()));
        return convPilha;

    }
    private PilhaNome converterPilhaNome(PileName pileName){
        PilhaNome convPilhaNome = new PilhaNome();
        convPilhaNome.setRestante(pileName.getRemaining());
        ArrayList<Cartas> cartas = new ArrayList<>();
        for (int i = 0; i < pileName.getCards().size(); i++) {
            Cards card = pileName.getCards().get(i);
            Cartas carta = this.converterCarta(card);
            cartas.add(carta);
        }
        convPilhaNome.setCartas(cartas);
        return convPilhaNome;
    }

    private String booleanToString(Boolean valor){
        if (valor) {
            return "verdadeiro";
        }
        return "falso";
    }
    public Baralho listarPilha(String deck_id, String piles){
        Deck deckListar = feignCardClient.listToPile(deck_id, piles);
        Baralho listarBaralho = new Baralho();
        listarBaralho.setSucesso(this.booleanToString(deckListar.getSuccess()));
        listarBaralho.setBaralho_id(deckListar.getDeck_id());
        listarBaralho.setRestante(deckListar.getRemaining());
        listarBaralho.setPilhaNome(this.converterPilha(deckListar.getPileName()));

        return listarBaralho;
    }
}
