package com.company.JeuSquidGameBilles;

import static java.lang.Math.min;

public class Joueur {
    final static String ennemisNames[] = {"safa","karl", "daniel", "simon","abdourahman",
            "samih", "roger", "khaled","pierre","bruno","jack","sarah","frederic",
            "emmanuel","georges","gregoire", "amelie","sandrine","France","SagaAfrica"};
    //constructeur
    public Joueur(int nmbDeBilles, String name, int age) {
        this.nmbDeBilles = nmbDeBilles;
        this.name = name;
        this.age = age;
    }
    public Joueur (){

    }

    // liste des champs
    // nmb de billes au depart est aleatoire
    private int nmbDeBilles = 10;
    // avoir une liste de 60 noms et quand un personnage est creer on choisir au hasard som dans la liste
    private String name = "";
    // age est aleatoir compris entre 5 et 99
    private int age = 0;


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
        /*if (nmb <= 0)
            throw new IllegalArgumentException("entrer un nombre positif");*/
        this.nmbDeBilles = nmb;
    };
    public int getNmbBilles() { return this.nmbDeBilles;};

    public void setName(String name) { this.name = name;};
    public String getName() { return this.name;};

    public boolean hasLost() {
        return (this.getNmbBilles() <= 0);
    }
    public int chooseNmbBilles(int nmbDeBillesHero){
        return Game.piocheHasard(1, min(this.getNmbBilles(),nmbDeBillesHero));
    }
    public int choosePairOrNot(){
       return Console.inputControl(this.getName() + " doit choisir impair = 1 ou pair = 0 ", 1 , 0 );
    }
    public static Joueur[] createListeEnnemis(int gameLevel){

        //TODO: create liste d'objet ennemis
        int nmbEnnemis = Game.giveNmbEnnemis(gameLevel) + 1;

        Joueur[] listeEnnemis = new Joueur[nmbEnnemis];
        //boucle for en fonction du niveau du jeu
        // Create ennemis
        for (int i =0; i< nmbEnnemis; i++){

            // tous les ennemis commence avec 20 billes
            int nmbDeBilles = 20;
            // choisi un nom au hasard parmis une liste de noms
            String name = Joueur.ennemisNames[ Game.piocheHasard( 0, Joueur.ennemisNames.length)];
            // choisi un age au hasard
            int age = Game.piocheHasard(5,99);

            //creation du joueur ennemi
            Joueur ennemi = new Joueur(nmbDeBilles,name,age);
            //ajout de chaque ennemi a la liste
            listeEnnemis[i] = ennemi;
        }
        return listeEnnemis;
    }
}
