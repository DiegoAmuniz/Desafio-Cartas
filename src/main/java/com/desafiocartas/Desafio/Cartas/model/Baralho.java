package com.desafiocartas.Desafio.Cartas.model;

import java.util.List;

public class Baralho {
    private boolean sucesso;
    private List<Carta> cartas;
    private String baralho_id;
    private Integer restante;
    private Boolean embaralhado;
    private Pilhas pilhas;

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public String getBaralho_id() {
        return baralho_id;
    }

    public void setBaralho_id(String baralho_id) {
        this.baralho_id = baralho_id;
    }

    public Integer getRestante() {
        return restante;
    }

    public void setRestante(Integer restante) {
        this.restante = restante;
    }

    public Boolean getEmbaralhado() {
        return embaralhado;
    }

    public void setEmbaralhado(Boolean embaralhado) {
        this.embaralhado = embaralhado;
    }

    public Pilhas getPilhas() {
        return pilhas;
    }

    public void setPilhas(Pilhas pilhas) {
        this.pilhas = pilhas;
    }
}
