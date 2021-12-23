
package com.company.JeuSquidGameBilles;
        import java.awt.*;
        import java.text.NumberFormat;
        import java.util.*;

        import java.util.Arrays;

public class Main {
        public static void main(String args[]) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("entrer le nom du premier joueur : ");
                String name1 = scanner.next();
                System.out.println("entrer le nom du deuxieme joueur : ");
                String name2 = scanner.next();
                Game game1 = new Game();
                Joueur joueur1 = new Joueur();
                joueur1.setName(name1);
                Joueur joueur2 = new Joueur();
                joueur2.setName(name2);


                while((joueur1.getNmbBilles() > 0 ) && (joueur2.getNmbBilles() > 0 )){
                        game1.playGame(joueur1,joueur2);
                        game1.switchPlayers(joueur1,joueur2);
                }
                if (joueur1.getNmbBilles() <= 0 ){
                        System.out.println(joueur1.getName() + " a perdu toutes ses billes le jeu est termine\n" + joueur2.getName() +" est le gagnant !");
                }else {
                        System.out.println(joueur2.getName() + " a perdu toutes ses billes le jeu est termine \n" + joueur1.getName() +" est le gagnant !");
                }


        }


}