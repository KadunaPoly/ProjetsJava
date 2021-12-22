
package com.company;
        import java.awt.*;
        import java.text.NumberFormat;
        import java.util.*;

        import java.util.Arrays;

public class Main {
        public static void main(String args[]) {
                System.out.println("hello");
                hideConsoledeWich();
                Scanner scanner = new Scanner(System.in);

                System.out.println("entrer le nom du premier joueur : ");
                String name1 = scanner.next();
                System.out.println("entrer le nom du deuxieme joueur : ");
                String name2 = scanner.next();

                Joueur joueur1 = new Joueur();
                joueur1.setName(name1);
                Joueur joueur2 = new Joueur();
                joueur2.setName(name2);


                while((joueur1.getNmbBilles() > 0 ) && (joueur2.getNmbBilles() > 0 )){
                        playGame(joueur1,joueur2);
                        switchPlayers(joueur1,joueur2);
                }
                if (joueur1.getNmbBilles() <= 0 ){
                        System.out.println(joueur1.getName() + " a perdu toutes ses billes le jeu est termine");
                }else {
                        System.out.println(joueur2.getName() + " a perdu toutes ses billes le jeu est termine");
                }


        }

        public static int inputControl(String msg, int max, int min) {

                Scanner scanner = new Scanner(System.in);
                int value;

                System.out.println(msg);

                while (true) {

                        while (!scanner.hasNextInt()) {
                                scanner.next();
                                System.out.print("merci dentrer une valeur numerique: ");
                        }
                        value = scanner.nextInt();

                        if (value >= min && value <= max)
                                break;
                        System.out.print("merci dentrer une valeur entre " + min + " and " + max +" : ");
                }

                return value;

        }
        public static boolean isPair( int nmb) {
               if(nmb%2==0){ return true;}
               return false;

        }
        public static void tranferNmbBilles( Joueur j1, Joueur j2,int nmbBilles) {
                j1.setNmbBilles(j1.getNmbBilles() - nmbBilles);
                j2.setNmbBilles(j2.getNmbBilles() + nmbBilles);
        }
        public static void whoWin( Joueur j1, Joueur j2,int nmbBilles, int bool) {
                if ((bool == 1 && isPair(nmbBilles))|| (bool == 0 && !isPair(nmbBilles))){
                        System.out.println("Perdu, on change les roles");
                }
                else if ( (bool == 0 && isPair(nmbBilles))|| (bool == 1 && !isPair(nmbBilles))){
                        System.out.println("gagne ! le joueur "+ j1.getName() +" vole " + nmbBilles + " billes au joeur "+ j2.getName() +".");
                        tranferNmbBilles(j1,j2,nmbBilles);
                }
        }
        public static void playGame(Joueur j1, Joueur j2) {
                halfGame(j1, j2);
                showNmbBilles(j1,j2);

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
                int nmbBilles = inputControl(j1.getName() + " doit choisir un nombre de billes : ", j1.getNmbBilles(), 1);
                hideConsoledeWich();
                int bool =  inputControl(j2.getName() + " doit choisir impair = 1 ou pair = 0 ", 1 , 0 );
                hideConsoledeWich();
                whoWin(j1,j2,nmbBilles,bool);
        }
        public static void showNmbBilles( Joueur j1, Joueur j2) {
                System.out.println(j1.getName() +" a " + j1.getNmbBilles() + " billes restantes.");
                System.out.println(j2.getName() +" a " + j2.getNmbBilles() + " billes restantes.");

        }
        public static void hideConsoledeWich(){
                for (int i = 0; i<20;i++) {
                        System.out.println("\b\b\b\b\b\b\b");
                }
        }
}