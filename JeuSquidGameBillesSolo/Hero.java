package com.company.JeuSquidGameBilles;

public class Hero extends Joueur{
    public Hero(int heroID){
        super();

        if ( heroID == 1){
            //Seong Gi-hun: 10 billes / bonus: 1 / malus: 3
            this.setName("Seong Gi-hun");
            this.setNmbBilles(10);
            this.malus = 3;
            this.bonus = 1;
        }else if(heroID == 2){
            // Kang Sae-byeok: 15 billes / bonus: 2 / malus: 2
            this.setName("Kang Sae-byeok");
            this.setNmbBilles(15);
            this.malus = 2;
            this.bonus = 2;
        }else {
            //Cho Sang-woo :  25 billes / bonus: 3 / malus: 1
            this.setName("Cho Sang-woo");
            this.setNmbBilles(25);
            this.malus = 1;
            this.bonus = 3;
        }
    }
    private int malus;
    private int bonus;

    public int getMalus() {
        return malus;
    }

    public void setMalus(int malus) {
        this.malus = malus;
    }
    public int getBonus() {
        return bonus;
    }

    public void setBonus(int malus) {
        this.bonus = bonus;
    }
}