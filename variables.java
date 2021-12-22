package com.company;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class variables {

    public static void main(String[] args) {

        int min = 1;
        int max = 10;
        int compteurVie = 3;

        Random random = new Random();

        int aTrouver = random.nextInt(max + min) + min;


        Scanner reader = new Scanner(System.in);

        while (compteurVie != 0) {
            System.out.println("Entrer la valeur a trouver: ");
            int essai = reader.nextInt();
            System.out.println("il vous reste " + compteurVie + "vie(s).");
            if (essai > 10 || essai < 0) {
                System.out.println("rentrer un chiffre compris entre 0 et 10 ");
            }else if(aTrouver > essai){
                System.out.println("le chiffre a trouver est plus grand");
                compteurVie--;
            }else if(aTrouver < essai){
                System.out.println("le chiffre a trouver est plus petit");
                compteurVie--;
            }else {

                break;
            }
        }
        if (compteurVie == 0) {
            System.out.println("reessayer dommage");
        }else {
            System.out.println("vous avez gagne !");
        }
    }

}

