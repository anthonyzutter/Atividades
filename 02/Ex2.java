package ex;

import java.util.Scanner;

/* Faça um algoritmo que leia três valores inteiros e mostre no navegador:
V1 + V2;
V2 - V1;
V3 * V1;
V3 + V2;
V3 - V2;
V1 + V2 + V3. */
public class Ex2 {

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite três valores: ");
        int V1 = teclado.nextInt();
        int V2 = teclado.nextInt();
        int V3 = teclado.nextInt();

        System.out.println(V1 + " + " + V2 + " = " + (V1 + V2));
        System.out.println(V2 + " - " + V1 + " = " + (V2 - V1));
        System.out.println(V3 + " * " + V1 + " = " + (V3 * V1));
        System.out.println(V3 + " + " + V2 + " = " + (V3 + V2));
        System.out.println(V3 + " - " + V2 + " = " + (V3 - V2));
        System.out.println(V1 + " + " + V2 + " + " + V3 + " = " + (V1 + V2 + V3));
    }
}


