package com.company;

public class Joueur {

    // liste des champs
    private int nmbDeBilles = 10;
    private String name;


    // liste des méthodes
    public void setNmbBilles(int nmb) { this.nmbDeBilles = nmb;};
    public int getNmbBilles() { return this.nmbDeBilles;};
    public void setName(String name) { this.name = name;};
    public String getName() { return this.name;};
}
