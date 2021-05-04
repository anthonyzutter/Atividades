package ex_vetores;

import java.util.Scanner;

public class Ex2 {
    public static String[][] pilha = new String[10][4];
    public static int indexPilha = -1;

    public static void main(String[] args) {
        String caixa[] = new String[4];
        Scanner tc = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 4) {
            System.out.println("1 - Empilhar caixa, 2 - Desempilhar caixa, 3 - Printar pilha, 4 - Sair");
            opcao = Integer.parseInt(tc.nextLine());
            if (opcao == 1) {
                System.out.println("Altura: ");
                caixa[0] = tc.nextLine();
                System.out.println("Largura: ");
                caixa[1] = tc.nextLine();
                System.out.println("Profundidade: ");
                caixa[2] = tc.nextLine();
                System.out.println("Fragil: ");
                caixa[3] = tc.nextLine();
                empilharCaixa(caixa);
            } else if (opcao == 2) {
                pilha = desempilharCaixa();
            } else if (opcao == 3) {
                for (int i = 0; i < pilha.length; i++) {
                    if (pilhaVazia()) {
                        System.out.println("Pilha vazia");
                        break;
                    } else if (pilha[i][0] == null) {
                        break;
                    }
                    System.out.println("Caixa " + (i + 1) + ", Altura: " + pilha[i][0] + ", Largura: " +
                            pilha[i][1] + ", Profundidade: " + pilha[i][2] + ", Fragil: " + pilha[i][3]);
                }
            } else if (opcao < 1 || opcao > 4) {
                System.out.println("Opção inválida");
            }
        }
    }

    public static boolean pilhaVazia() {
        if (indexPilha == -1) {
            return true;
        }
        return false;
    }

    public static void empilharCaixa(String[] caixa) {
        if (indexPilha < pilha.length -1) {
            pilha[++indexPilha][0] = caixa[0];
            pilha[indexPilha][1] = caixa[1];
            pilha[indexPilha][2] = caixa[2];
            pilha[indexPilha][3] = caixa[3];
        } else {
            System.out.println("Número maximo de caixas empilhadas");
        }
    }

    public static String[][] desempilharCaixa() {
        String[][] novaPilha = new String[pilha.length][4];
        if (pilhaVazia()) {
            System.out.println("Nenhuma caixa para desempilhar");
            return null;
        }
        for (int i = 0; i < pilha.length; i++) {
            if (i == indexPilha) {
                break;
            }
            novaPilha[i] = pilha[i];
        }
        indexPilha--;
        return novaPilha;
    }
}
