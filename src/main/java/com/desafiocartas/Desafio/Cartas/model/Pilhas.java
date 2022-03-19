package com.desafiocartas.Desafio.Cartas.model;

import java.util.List;

public class Pilhas {
    private String nome_pilha;
    private List<Carta> cartas;
    private Integer restante;

    public String getNome_pilha() {
        return nome_pilha;
    }

    public void setNome_pilha(String nome_pilha) {
        this.nome_pilha = nome_pilha;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public Integer getRestante() {
        return restante;
    }

    public void setRestante(Integer restante) {
        this.restante = restante;
    }
}
