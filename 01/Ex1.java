package exercicios;

import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        //Declarando as variáveis
        int num1, num2;
        int resultado;

        //Entrada
        Scanner teclado = new Scanner(System.in);
        System.out.println("*** Calculadora de multiplicação ***");
        System.out.println("Digite dois números inteiros:");
        num1 = teclado.nextInt();
        num2 = teclado.nextInt();

        //Processamento
        resultado = num1 * num2;

        //Saída
        System.out.println("O resultado da multiplicação é de " + resultado);
    }
}
