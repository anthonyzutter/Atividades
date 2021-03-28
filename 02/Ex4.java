package ex;

import java.util.Scanner;

// Faça um algoritmo que leia um determinado valor real, calcule e mostre este valor acrescido de 15,8%.
public class Ex4 {

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite um valor: ");
        double valor = teclado.nextDouble();
        valor *= 1.158;
        System.out.println("O valor " + valor + " acrescido de 15,8% é de " + valor);
    }
}
