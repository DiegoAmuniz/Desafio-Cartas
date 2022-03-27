package com.desafiocartas.Desafio.Cartas.model;

import java.util.List;

public class Baralho {
    public String sucesso;
    public String baralho_id;
    public List<Carta> cartas;
    public Integer restante;
    public Pilhas pilhas;
    public String embaralhado;

    public void setSucesso(String sucesso) {
        this.sucesso = sucesso;
    }

    public void setBaralho_id(String baralho_id) {
        this.baralho_id = baralho_id;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public void setRestante(Integer restante) {
        this.restante = restante;
    }

    public void setPilhas(Pilhas pilhas) { this.pilhas = pilhas; }

    public void setEmbaralhado(String embaralhado) { this.embaralhado = embaralhado; }
}
