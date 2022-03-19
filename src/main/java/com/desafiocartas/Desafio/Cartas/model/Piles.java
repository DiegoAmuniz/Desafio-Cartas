package com.desafiocartas.Desafio.Cartas.model;

import java.util.List;

public class Piles {
    private String pile_name;
    private List<Card> cards;
    private Integer remaining;

    public String getPile_name() {
        return pile_name;
    }

    public void setPile_name(String pile_name) {
        this.pile_name = pile_name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }
}
