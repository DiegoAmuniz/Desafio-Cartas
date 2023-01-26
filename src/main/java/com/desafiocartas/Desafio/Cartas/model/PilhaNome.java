package com.desafiocartas.Desafio.Cartas.model;
import java.util.ArrayList;

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
