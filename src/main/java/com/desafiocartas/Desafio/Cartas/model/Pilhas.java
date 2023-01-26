package com.desafiocartas.Desafio.Cartas.model;

public class Pilhas {
    PilhaNome PilhaNome;
    Descarte descarte;

    public void setPilhaNome(com.desafiocartas.Desafio.Cartas.model.PilhaNome pilhaNome) {
        PilhaNome = pilhaNome;
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
