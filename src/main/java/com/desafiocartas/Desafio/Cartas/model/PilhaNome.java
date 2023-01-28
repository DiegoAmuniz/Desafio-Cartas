package com.desafiocartas.Desafio.Cartas.model;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PilhaNome {
    public Float restante;
    public ArrayList<Cartas> Cartas = new ArrayList<>();

    public void setRestante(Float restante) {
        this.restante = restante;
    }

    public void setCartas(ArrayList<com.desafiocartas.Desafio.Cartas.model.Cartas> cartas) {
        Cartas = cartas;
    }
}
