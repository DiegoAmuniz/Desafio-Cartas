package com.desafiocartas.Desafio.Cartas.model;

import java.util.List;

public class Deck {
    public boolean success;
    public String deck_id;
    public List<Card> cards;
    public Integer remaining;
    public Piles piles;
    public boolean shuffled;

    public boolean getSuccess() {
        return this.success;
    }

    public String getDeck_id() {
        return this.deck_id;
    }

    public List<Card> getCards() { return this.cards; }

    public Integer getRemaining() {
        return this.remaining;
    }

    public Piles getPiles() {
        return piles;
    }

    public boolean getShuffled() {
        return this.shuffled;
    }
}