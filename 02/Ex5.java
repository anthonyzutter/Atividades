package ex;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o valor da base: ");
        int base = teclado.nextInt();
        System.out.println("Digite o valor da altura: ");
        int altura = teclado.nextInt();
        System.out.println("Area: " + base * altura / 2);
    }
}
