package com.company.JeuSquidGameBilles;

public class Joueur {

    // liste des champs
    // nmb de billes au depart est aleatoire
    private int nmbDeBilles = 10;
    // avoir une liste de 60 noms et quand un personnage est creer on choisir au hasard som dans la liste
    private String name = "";
    // age est aleatoir compris entre 5 et 99
    private int age =0;

    public int getAge() {
        return age;
    }
    private void setAge( int age){
        if (age < 0)
            throw new IllegalArgumentException("entrer un nombre positif");
        this.age = age;

    }

    // liste des méthodes
    public void setNmbBilles(int nmb) {
        if (nmb < 0)
            throw new IllegalArgumentException("entrer un nombre positif");
        this.nmbDeBilles = nmb;
    };
    public int getNmbBilles() { return this.nmbDeBilles;};

    public void setName(String name) { this.name = name;};
    public String getName() { return this.name;};
}
