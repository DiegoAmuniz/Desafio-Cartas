package com.desafiocartas.Desafio.Cartas.model;

public class Piles {
    PileName PileName;
    Discard discard;

    public com.desafiocartas.Desafio.Cartas.model.PileName getPileName() {
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
