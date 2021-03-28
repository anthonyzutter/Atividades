package ex;

import java.util.Scanner;

// Faça um algoritmo que leia dois números inteiros, execute e mostre as quatro operações aritméticas básicas
public class Ex1 {

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o primeiro número: ");
        int n1 = teclado.nextInt();
        System.out.println("Digite o segundo número: ");
        int n2 = teclado.nextInt();
        System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
        System.out.println(n1 + " - " + n2 + " = " + (n1 - n2));
        System.out.println(n1 + " * " + n2 + " = " + (n1 * n2));
        System.out.println(n1 + " / " + n2 + " = " + (n1 / n2));
    }
}
