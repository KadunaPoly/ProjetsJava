package com.company.JeuSquidGameBilles;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import java.util.Random;

import static java.lang.Math.min;

public class Game {
    // ----------------Attributs-----------------------//
    private int gameLevel =1;
    /*public Map<Integer, Integer> myMap;
    Map<String, String> map = new HashMap<String, String>();
    map.put("dog", "type of animal");
    System.out.println(map.get("dog"));;*/


    // ----------------getters et setters-----------------------//
    public int getGameLevel() {
        return gameLevel;
    }
    public void setGameLevel(int gameLevel) {
        if (gameLevel < 1 || gameLevel > 4 )
            throw new IllegalArgumentException("entrer un nombre compris entre 1 et 3");
         this.gameLevel = gameLevel;
    }

    // ----------------methodes-----------------------//

    public void chooseLevel(){
        //TODO: propose au joueur un choix entre 3 niveaux
        // niveau facile : 4 combats
        // niveau difficile : 12 combats
         // niveau impossible : 18 combats
        int level = Console.inputControl("choisir un niveau entre 1 et 3 : \n " +
                "niveau 1 : 4 combats " +
                "\n niveau 2 : 12 combats " +
                "\n niveau 3 : 18 combats", 3, 1);
        this.setGameLevel(level);
    }

    public static Hero chooseHero (){
        //TODO: proposer un choix entre trois joueur
        //Seong Gi-hun: 10 billes / bonus: 1 / malus: 3
        // Kang Sae-byeok: 15 billes / bonus: 2 / malus: 2
        //Cho Sang-woo :  25 billes / bonus: 3 / malus: 1

        int heroID = Console.inputControl("choisir un Hero : \n " +
                "hero 1 : Seong Gi-hun: 10 billes - bonus: 1 - malus: 3 " +
                "\n hero 2 : Kang Sae-byeok: 15 billes - bonus: 2 - malus: 2 " +
                "\n hero 3 : Cho Sang-woo :  25 billes - bonus: 3 - malus: 1", 3, 1);
        Hero hero = new Hero(heroID);
        return hero;
    }

    public boolean isOld(Joueur ennemi){
        //TODO: test si le joueur a plus de 70 ans
        if(ennemi.getAge() > 69){
            System.out.println("L'ennemi a " + ennemi.getAge() + "ans ");
            return true;
        }
        return (false);

    }
    public boolean tricher(Hero hero,Joueur ennemi){
        //Choisir entre tricher ou non:
        int bool =  Console.inputControl( "Voulez vous tricher ? Oui = 0 / Non = 1", 1 , 0 );
        if (bool == 0){
            // SI OUI: voler toutes les billes de lennemi
            System.out.println("vous avez vole "+ ennemi.getNmbBilles()+ " au joueur " + ennemi.getName() +".\n");
            tranferNmbBillesVictory(hero,ennemi,ennemi.getNmbBilles(),0);
            return true;
        }// SI NON : la partie continue
        return false;
    }

    public void playGame(Hero hero, Joueur ennemi) {
        System.out.println("la partie va commencer, "+ hero.getName() + " joue contre "+ ennemi.getName());
        //Si lennemi est vieux et tricher est vrai
        if (isOld(ennemi) && tricher(hero,ennemi)) {

        }else {
            //SI NON : la partie continue
            //ennemi choisi parmis ses billes un nmb de billes aleatoire
            int nmbBillesEnnemi = ennemi.chooseNmbBilles(hero.getNmbBilles());

            //le hero choisi entre pair et impair
            int bool = hero.choosePairOrNot();

            //pour savoir qui gagne
            whoWin(hero,ennemi,nmbBillesEnnemi,bool);
        }
    }
   /* public static void switchPlayers( Joueur j1, Joueur j2) {
        String tempName = j1.getName();
        int tempNmbBilles = j1.getNmbBilles();
        j1.setName(j2.getName());
        j1.setNmbBilles(j2.getNmbBilles());
        j2.setName(tempName);
        j2.setNmbBilles(tempNmbBilles);
    }*/

    public static void whoWin( Hero hero, Joueur ennemi,int nmbBilles, int bool) {
        //TODO: ajouter malus et bonus
        //si le hero gagne : hero a dit pair et ennemi avait pair  OU hero a dit impair et ennemi avait impair
        if ((bool == 1 && isPair(nmbBilles)) || (bool == 0 && !isPair(nmbBilles))){
            System.out.println("gagne ! le hero "+ hero.getName() +" vole " + nmbBilles + " billes a l'ennemi "+ ennemi.getName() +".");
            tranferNmbBillesVictory(hero,ennemi,nmbBilles,hero.getBonus());
        }
        //si le hero perds : hero a dit impair et ennemi avait pair  OU hero a dit pair et ennemi avait impair
        else if ( (bool == 0 && isPair(nmbBilles))|| (bool == 1 && !isPair(nmbBilles))){
            System.out.println("perdu ! l'ennemi "+ ennemi.getName() +" vole " + nmbBilles + " billes au hero "+ hero.getName() +".");
            tranferNmbBillesLost(hero,ennemi,nmbBilles,hero.getMalus());
        }
    }

    public static boolean isPair( int nmb) {
        if(nmb % 2 == 0){ return true;}
        return false;
    }
    public static void tranferNmbBillesVictory(Hero hero, Joueur ennemi,int nmbBilles, int bonus) {
        //Transfer le bonus
        ennemi.setNmbBilles(ennemi.getNmbBilles() - nmbBilles - bonus);
        hero.setNmbBilles(hero.getNmbBilles() + nmbBilles + bonus);
    }
    public static void tranferNmbBillesLost(Hero hero, Joueur ennemi,int nmbBilles, int malus) {
        //transfer le malus
        hero.setNmbBilles(hero.getNmbBilles() - nmbBilles - malus);
        ennemi.setNmbBilles(ennemi.getNmbBilles() + nmbBilles + malus);
    }
    public static int piocheHasard(int min, int max){
        Random random = new Random();

       return (random.nextInt(max + min) + min);

    }
    public static int giveNmbEnnemis(int gameLevel){
        if(gameLevel == 1){
            return 4;
        }else if(gameLevel == 2){
            return 12;
        }else
            return 18;
    }
    public static void secondHalf(Joueur ennemi, Hero hero){
        int nmbDeBilles = Console.inputControl("entrer un nombre de billes a mettre en jeu : ", min(hero.getNmbBilles(),ennemi.getNmbBilles()),1);
        int bool = ennemi.choosePairOrNot();
        whoWin(hero,ennemi,nmbDeBilles,bool);
    }


}
