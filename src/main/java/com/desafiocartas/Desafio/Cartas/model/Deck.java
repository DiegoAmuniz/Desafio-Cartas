package com.desafiocartas.Desafio.Cartas.model;
import java.util.ArrayList;

public class Deck {
    public boolean success;
    public String deck_id;
    public boolean shuffled;
    public Float remaining;
    public Piles PileName;
    public ArrayList < Cards > cards = new ArrayList<>();

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

    public Piles getPileName() {
        return PileName;
    }

    public ArrayList<Cards> getCards() {
        return cards;
    }
}

