package ex;

import java.time.LocalDate;
import java.util.Scanner;

//Faça um algoritmo que leia o ano de nascimento de uma pessoa, calcule e mostre sua idade aproximada.
// Buscar no Google uma função que retorne a data atual (do momento).
public class Ex3 {

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        LocalDate data = LocalDate.now();
        System.out.println("Digite o ano que você nasceu: ");
        int nascimento = teclado.nextInt();
        System.out.println("Idade: " + (data.getYear() -nascimento));
    }
}
