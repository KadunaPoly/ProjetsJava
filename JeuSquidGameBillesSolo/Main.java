package com.company.JeuSquidGameBilles;

public class Main {
        public static void main(String args[]) {

                //creation de la partie
                Game game1 = new Game();
                //choix du niveau
                game1.chooseLevel();
                //choix du hero
                Hero hero = game1.chooseHero();
                //creer la liste d'ennemis
                Joueur[] listeEnnemis = Joueur.createListeEnnemis(game1.getGameLevel());

                //TODO: while tant que la liste des ennemis n est pas vide et tant quon ne perds pas

                int ennemiID = 0;

                while ( ennemiID < listeEnnemis.length-1 && !hero.hasLost()){

                        //verifie si le joueur ou lennemi a encore des billes
                        while((!hero.hasLost()) && (!listeEnnemis[ennemiID].hasLost() )){
                                game1.playGame(hero,listeEnnemis[ennemiID]);
                                Console.showNmbBilles(hero,listeEnnemis[ennemiID]);
                                if((hero.hasLost()) || (listeEnnemis[ennemiID].hasLost() ))
                                        break;
                                game1.secondHalf(listeEnnemis[ennemiID],hero);
                                Console.showNmbBilles(hero,listeEnnemis[ennemiID]);
                        }
                        // si cest lennemi qui a perdu
                        if(listeEnnemis[ennemiID].hasLost() ){
                                System.out.println(listeEnnemis[ennemiID].getName() + " a perdu toutes ses billes\n");
                                //passe a lennemi suivant
                                ennemiID++;
                        }
                }
                // TODO: si le joueur na plus de billes il faut arreter le programme
                //mettre fin au programme
                if (!hero.hasLost())
                        System.out.println(hero.getName() +" est le gagnant ! les jeu est termine");
                else{
                        System.out.println("Dommage");
                }
        }

}
