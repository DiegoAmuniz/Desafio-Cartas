package com.desafiocartas.Desafio.Cartas.model;

public class Piles {
    public PileName PileName;
    public Discard discard;

    public PileName getPileName() {
        return PileName;
    }

    public Discard getDiscard() {
        return discard;
    }

    public class Discard {
        private float remaining;

        public float getRemaining() {
            return remaining;
        }
    }
}
