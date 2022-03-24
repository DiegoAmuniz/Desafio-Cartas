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
        return success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public Piles getPiles() {
        return piles;
    }

    public boolean getShuffled() {
        return shuffled;
    }
}