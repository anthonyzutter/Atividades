package matrizes;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        String[] lojas = new String[8];
        String[] produtos = new String[4];
        double[][] valores = new double[lojas.length][produtos.length];
        Scanner tc = new Scanner(System.in);

        for (int i = 0; i < lojas.length; i++) {
            System.out.println("Nome da loja " + (i+1) + ": ");
            lojas[i] = tc.nextLine();
        }
        for (int i = 0; i < produtos.length; i++) {
            System.out.println("Nome do produto " + (i+1) + ": ");
            produtos[i] = tc.nextLine();
        }
        for (int i = 0; i < lojas.length; i++) {
            for (int j = 0; j < produtos.length; j++) {
                System.out.println("Valor do " + produtos[j] + " da loja " + lojas[i] + ": ");
                valores[i][j] = tc.nextDouble();
            }
        }
        for (int i = 0; i < lojas.length; i++) {
            for (int j = 0; j < produtos.length; j++) {
                if (valores[i][j] < 120) {
                    System.out.println(produtos[j] + " da loja " + lojas[i] + " custa R$ " + valores[i][j]);
                }
            }
        }
    }
}
