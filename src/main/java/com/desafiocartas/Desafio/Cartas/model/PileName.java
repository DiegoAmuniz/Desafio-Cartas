package com.desafiocartas.Desafio.Cartas.model;
import java.util.ArrayList;

public class PileName {
    private Float remaining;
    private ArrayList<Cards> cards = new ArrayList<>();

    public Float getRemaining() {
        return remaining;
    }

    public ArrayList<Cards> getCards() {
        return cards;
    }
}