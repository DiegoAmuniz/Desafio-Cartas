package com.desafiocartas.Desafio.Cartas.model;

public enum SuitType {

    SPADES("ESPADAS"),

    HEARTS("COPAS"),

    CLUBS("PAUS"),

    DIAMONDS("OUROS");

    private String suitName;

    private SuitType(String suitName) {
        this.suitName = suitName;

    }

    public String getSuitName() {
        return suitName;
    }
}