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
        baralho.setSucesso(booleanToString(deck.getSuccess()));
        baralho.setBaralho_id(deck.getDeck_id());
        baralho.setRestante(deck.getRemaining());
        baralho.setEmbaralhado(booleanToString(deck.getShuffled()));
        return baralho;
    }
    public Baralho embaralhado(String id){
        Deck deckEmbaralhado = feignCardClient.shuffleDeckById(id);
        Baralho embaralhado = new Baralho();
        embaralhado.setSucesso(booleanToString(deckEmbaralhado.getSuccess()));
        embaralhado.setBaralho_id(deckEmbaralhado.getDeck_id());
        embaralhado.setRestante(deckEmbaralhado.getRemaining());
        embaralhado.setEmbaralhado(booleanToString(deckEmbaralhado.getShuffled()));
        return embaralhado;

    }

    public Baralho novoEmbaralhar(String deckCount){
        Deck deckNovoEmbaralhar = feignCardClient.newDeckShuffle(deckCount);
        Baralho novoEmbaralhar = new Baralho();
        novoEmbaralhar.setSucesso(booleanToString(deckNovoEmbaralhar.getSuccess()));
        novoEmbaralhar.setBaralho_id(deckNovoEmbaralhar.getDeck_id());
        novoEmbaralhar.setEmbaralhado(booleanToString(deckNovoEmbaralhar.getShuffled()));
        novoEmbaralhar.setRestante(deckNovoEmbaralhar.getRemaining());
        return novoEmbaralhar;
    }

    public Baralho baralhoParcial(String deck){
        Deck deckParcial = feignCardClient.parcialDeck(deck);
        Baralho parcial = new Baralho();
        parcial.setSucesso(booleanToString(deckParcial.getSuccess()));
        parcial.setBaralho_id(deckParcial.getDeck_id());
        parcial.setRestante(deckParcial.getRemaining());
        parcial.setEmbaralhado(booleanToString(deckParcial.getShuffled()));
        return parcial;
    }

    public Baralho desenhar(String deckId, String count){
        Deck desenharDeck = feignCardClient.drawDeck(deckId, count);
        Baralho desenhar = new Baralho();
        desenhar.setSucesso(booleanToString(desenharDeck.getSuccess()));
        desenhar.setBaralho_id(desenharDeck.getDeck_id());
        ArrayList<Cartas> cartas = new ArrayList<>();
                for (int i = 0; i < desenharDeck.getCards().size(); i++) {
                    Cards card = desenharDeck.getCards().get(i);
                    Cartas carta = converterCarta(card);
                    cartas.add(carta);
                }
                desenhar.setCartas(cartas);
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
        convCartas.setImagens(converterImagens(card.getImages()));
        convCartas.setTipo(converteNipe(card));
        convCartas.setValor(converteValor(card));
        return convCartas;
    }

    private Cartas.Imagens converterImagens(Cards.Images images){
        Cartas.Imagens convImagens = new Cartas.Imagens();
        convImagens.setPng(images.getPng());
        convImagens.setSvg(images.getSvg());
        return convImagens;
    }
    private Pilhas converterPilha(Piles pile) {
        Pilhas convPilha = new Pilhas();
        convPilha.setPilhaNome(converterPilhaNome(pile.getPileName()));
        convPilha.setDescarte(converterDescarte(pile.getDiscard()));
        return convPilha;

    }

    private Pilhas.Descarte converterDescarte(Piles.Discard discard){
        Pilhas.Descarte convDesc = new Pilhas.Descarte();
        convDesc.setRestante(discard.getRemaining());
        return convDesc;

    }
    private PilhaNome converterPilhaNome(PileName pileName){
        PilhaNome convPilhaNome = new PilhaNome();
        convPilhaNome.setRestante(pileName.getRemaining());
        ArrayList<Cartas> cartas = new ArrayList<>();
        for (int i = 0; i < pileName.getCards().size(); i++) {
            Cards card = pileName.getCards().get(i);
            Cartas carta = converterCarta(card);
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
        listarBaralho.setSucesso(booleanToString(deckListar.getSuccess()));
        listarBaralho.setBaralho_id(deckListar.getDeck_id());
        listarBaralho.setRestante(deckListar.getRemaining());
        listarBaralho.setPilhas(converterPilha(deckListar.getPiles()));

        return listarBaralho;
    }
}
