package com.desafiocartas.Desafio.Cartas.model;

import java.util.List;

public class Deck {
    private boolean success;
    private List<Card> cards;
    private String deck_id;
    private Integer remaining;
    private Boolean shuffled;
    private Piles piles;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public Boolean getShuffled() {
        return shuffled;
    }

    public void setShuffled(Boolean shuffled) {
        this.shuffled = shuffled;
    }

    public Piles getPiles() {
        return piles;
    }

    public void setPiles(Piles piles) {
        this.piles = piles;
    }
}