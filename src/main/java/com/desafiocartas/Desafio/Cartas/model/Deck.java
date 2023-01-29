package com.desafiocartas.Desafio.Cartas.model;
import java.util.ArrayList;

public class Deck {
    private boolean success;
    private String deck_id;
    private boolean shuffled;
    private Float remaining;
    private Piles piles;
    private ArrayList < Cards > cards = new ArrayList<>();

    public boolean getSuccess() {
        return success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public boolean getShuffled() {
        return shuffled;
    }

    public Float getRemaining() {
        return remaining;
    }

    public Piles getPiles() { return piles; }

    public ArrayList<Cards> getCards() {
        return cards;
    }
}

