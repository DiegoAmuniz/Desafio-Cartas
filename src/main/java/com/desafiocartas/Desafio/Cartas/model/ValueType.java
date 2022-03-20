package com.desafiocartas.Desafio.Cartas.model;

public enum ValueType {
    JACK("VALETE"),
    QUEEN("RAINHA"),
    KING("REI"),
    ACE("AS");

    private String valueName;

    private ValueType(String valueName){
        this.valueName = valueName;
    }

    public String getValueName(){
        return valueName;
    }

}