package com.desafiocartas.Desafio.Cartas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Pilhas {
    public PilhaNome pilhaNome;
    public Descarte descarte;

    public void setPilhaNome(PilhaNome pilhaNome) {
        this.pilhaNome = pilhaNome;
    }

    public void setDescarte(Descarte descarte) {
        this.descarte = descarte;
    }

    public class Descarte {
        private float restante;

        public void setRestante(float restante) {
            this.restante = restante;
        }
    }
}
