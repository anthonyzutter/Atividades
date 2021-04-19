package ex;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        int numTimes = 2;
        int numJogadores = 2;
        int totalJogadores = numTimes * numJogadores;
        int idade, peso, altura;
        int contadorIdade = 0, contadorAltura = 0, contadorJogadoresDeMenor = 0;
        double contadorJogadoresAcimaDoPeso = 0;
        String mediaIdade = "";

        Scanner tc = new Scanner(System.in);

        for (int t = 1; t < numTimes + 1; t++) {
            idade = 0;
            for (int j = 1; j < numJogadores + 1; j++) {
                System.out.println("Jogador " + j + " do time " + t + " idade: ");
                idade = tc.nextInt();
                System.out.println("Jogador " + j + " do time " + t + " peso(Kg): ");
                peso = tc.nextInt();
                System.out.println("Jogador " + j + " do time " + t + " altura(Cm): ");
                altura = tc.nextInt();

                if (idade < 18) {
                    contadorJogadoresDeMenor++;
                }
                if (peso > 80) {
                    contadorJogadoresAcimaDoPeso++;
                }
                contadorAltura += altura;
                contadorIdade += idade;
            }
            mediaIdade = mediaIdade.concat("Média da idade do time " + t + ": " + contadorIdade / numJogadores + " anos \n");
            // System.out.println("Média da idade do time " + t + ": " + contadorIdade / numJogadores + " anos");
        }
        System.out.println("Número de jogadores com menos de 18 anos: " + contadorJogadoresDeMenor);
        System.out.println("Média da altura dos jogadores: " + contadorAltura / totalJogadores + "cm");
        System.out.println("Porentagem de jogadores acima do peso: " + contadorJogadoresAcimaDoPeso / totalJogadores * 100 + "%");
        System.out.println(mediaIdade);
    }
}