package com.desafiocartas.Desafio.Cartas.model;

import java.util.List;

public class PileName {
    private Integer remaining;
    private List<Card> cards;

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
