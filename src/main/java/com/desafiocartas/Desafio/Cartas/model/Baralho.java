package com.desafiocartas.Desafio.Cartas.model;
import java.util.ArrayList;

public class Baralho {
    public String sucesso;
    public String baralho_id;
    public String embaralhado;
    public Float restante;
    public Pilhas PilhaNome;
    public ArrayList <Cartas> cartas = new ArrayList<>();

    public void setSucesso(String sucesso) {
        this.sucesso = sucesso;
    }

    public void setBaralho_id(String baralho_id) {
        this.baralho_id = baralho_id;
    }

    public void setEmbaralhado(String embaralhado) {
        this.embaralhado = embaralhado;
    }

    public void setRestante(Float restante) {
        this.restante = restante;
    }

    public void setPilhaNome(Pilhas pilhaNome) {
        PilhaNome = pilhaNome;
    }

    public void setCartas(ArrayList<Cartas> cartas) {
        this.cartas = cartas;
    }
}
