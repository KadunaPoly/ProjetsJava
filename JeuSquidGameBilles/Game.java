package com.company.JeuSquidGameBilles;


public class Game {
    public void chooseLevel(){

    }
    public static void playGame(Joueur j1, Joueur j2) {
        halfGame(j1, j2);
        Console.showNmbBilles(j1,j2);

    }
    public static void switchPlayers( Joueur j1, Joueur j2) {
        String tempName = j1.getName();
        int tempNmbBilles = j1.getNmbBilles();
        j1.setName(j2.getName());
        j1.setNmbBilles(j2.getNmbBilles());
        j2.setName(tempName);
        j2.setNmbBilles(tempNmbBilles);
    }
    public static void halfGame( Joueur j1, Joueur j2) {
        int nmbBilles = Console.inputControl(j1.getName() + " doit choisir un nombre de billes : ", j1.getNmbBilles(), 1);
        Console.hideConsoledeWich();
        int bool =  Console.inputControl(j2.getName() + " doit choisir impair = 1 ou pair = 0 ", 1 , 0 );
        Console.hideConsoledeWich();
        whoWin(j1,j2,nmbBilles,bool);
    }
    public static void whoWin( Joueur j1, Joueur j2,int nmbBilles, int bool) {
        if ((bool == 1 && isPair(nmbBilles)) || (bool == 0 && !isPair(nmbBilles))){
            System.out.println("Perdu, on change les roles");
            System.out.println("gagne ! le joueur "+ j1.getName() +" vole " + nmbBilles + " billes au joueur "+ j2.getName() +".");
            tranferNmbBilles(j2,j1,nmbBilles);
        }
        else if ( (bool == 0 && isPair(nmbBilles))|| (bool == 1 && !isPair(nmbBilles))){
            System.out.println("gagne ! le joueur "+ j2.getName() +" vole " + nmbBilles + " billes au joueur "+ j1.getName() +".");
            tranferNmbBilles(j1,j2,nmbBilles);
        }
    }
    public static boolean isPair( int nmb) {
        if(nmb % 2 == 0){ return true;}
        return false;
    }
    public static void tranferNmbBilles( Joueur j1, Joueur j2,int nmbBilles) {
        j1.setNmbBilles(j1.getNmbBilles() - nmbBilles);
        j2.setNmbBilles(j2.getNmbBilles() + nmbBilles);
    }

}
