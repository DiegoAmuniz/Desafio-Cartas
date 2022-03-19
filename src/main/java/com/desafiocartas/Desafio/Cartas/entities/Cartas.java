package com.iniciojava.springweb.entities;
import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Images{
    private String svg;
    private String png;
}

public class Card{
    private String code;
    private String image;
    private Images images;
    private String value;
    private String suit;
}

public class Root{
    private boolean success;
    private String deck_id;
    private ArrayList<Card> cards;
    private int remaining;
}

