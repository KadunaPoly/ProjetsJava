package com.company;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Entrer un chiffre: ");
        int num = reader.nextInt();
        if (num % 5 == 0)
            System.out.print("Fizz");
        if (num % 3 == 0)
            System.out.println("Buzz");
    }
}
