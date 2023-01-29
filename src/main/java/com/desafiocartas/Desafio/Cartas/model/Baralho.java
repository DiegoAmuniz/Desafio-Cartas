package com.desafiocartas.Desafio.Cartas.model;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Baralho {
    private String sucesso;
    private String baralho_id;
    private String embaralhado;
    private Float restante;
    private Pilhas pilhas;
    private ArrayList <Cartas> cartas = new ArrayList<>();

    public void setSucesso(String sucesso) {
        this.sucesso = sucesso;
    }

    public void setBaralho_id(String baralho_id) {
        this.baralho_id = baralho_id;
    }

    public void setEmbaralhado(String embaralhado) { this.embaralhado = embaralhado; }

    public void setRestante(Float restante) {
        this.restante = restante;
    }

    public void setPilhas(Pilhas pilhas) { this.pilhas = pilhas; }

    public void setCartas(ArrayList<Cartas> cartas) {
        this.cartas = cartas;
    }
}
