package exercicios;

import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {
        float num1, num2, num3;
        float media;

        Scanner teclado = new Scanner(System.in);
        System.out.println("*** Calculadora de média aritmética ***");
        System.out.println("Digite três números:");
        num1 = teclado.nextFloat();
        num2 = teclado.nextFloat();
        num3 = teclado.nextFloat();

        media = (num1 + num2 + num3) / 3;

        if (media >= 7) {
            System.out.println("A sua média é de " + String.format("%.2f", media) + " você foi aprovado.");
        } else {
            System.out.println("A sua média é de " + String.format("%.2f", media) + " você foi reprovado.");
        }
    }
}
