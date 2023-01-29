package com.desafiocartas.Desafio.Cartas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Pilhas {
    private PilhaNome pilhaNome;
    private Descarte descarte;

    public void setPilhaNome(PilhaNome pilhaNome) {
        this.pilhaNome = pilhaNome;
    }

    public void setDescarte(Descarte descarte) {
        this.descarte = descarte;
    }

    public static class Descarte {
        private float restante;

        public void setRestante(float restante) {
            this.restante = restante;
        }
    }
}
