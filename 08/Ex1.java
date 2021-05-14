package matrizes;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        int[][] m = new int[2][2];
        int maior = 0;
        Scanner tc = new Scanner(System.in);
        // Recebe os Valores e verifica qual o maior
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.println("Linha " + (i+1) + " Coluna " + (j+1) + " Valor: ");
                m[i][j] = tc.nextInt();
                if (m[i][j] > maior) {
                    maior = m[i][j];
                }
            }
        }
        // Multiplica os Valores e imprime
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.println(m[i][j] * maior);
            }
        }
    }
}
