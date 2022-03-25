package com.desafiocartas.Desafio.Cartas.model;

import java.util.List;

public class PilhaNome {
    public Integer restante;
    public List<Carta> cartas;

    public void setRestante(Integer restante) {
        this.restante = restante;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }
}
