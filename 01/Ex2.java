package exercicios;

import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {
        int num1, num2;
        int resultado;

        Scanner teclado = new Scanner(System.in);
        System.out.println("*** Calculadora de divisão ***");
        System.out.println("Digite dois números inteiros:");
        num1 = teclado.nextInt();
        num2 = teclado.nextInt();

        if (num2 == 0) {
            System.out.println("O segundo número não pode ser igual a zero.");
        } else {
            resultado = num1 / num2;
            System.out.println("O resultado da divisão é de " + resultado);
        }
    }
}
