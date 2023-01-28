package com.desafiocartas.Desafio.Cartas.model;
import java.util.ArrayList;

public class PileName {
    public Float remaining;
    public ArrayList<Cards> cards = new ArrayList<>();

    public Float getRemaining() {
        return remaining;
    }

    public ArrayList<Cards> getCards() {
        return cards;
    }
}