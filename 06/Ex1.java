package ex_vetores;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        double[] valorProdutos = new double[10];
        int[] quantProdutos = new int[10];
        double[] maisVendido = new double[2];
        double valorTotal;

        Scanner tc = new Scanner(System.in);

        for (int i = 0; i < valorProdutos.length; i++) {
            System.out.println("Valor do produto " + (i + 1) + " : ");
            valorProdutos[i] = tc.nextDouble();
            System.out.println("Quantidades vendidas do produto " + (i + 1) + " : ");
            quantProdutos[i] = tc.nextInt();
        }
        gerarRelatorio(valorProdutos, quantProdutos);
        valorTotal = valorTotalVendas(valorProdutos, quantProdutos);
        System.out.println("Valor total das vendas: R$ " + valorTotal);
        System.out.println("Valor da comissão do vendedor: R$ " + valorTotal * 0.05);
        maisVendido = produtoMaisVendido(valorProdutos, quantProdutos);
        System.out.println("Valor do objeto mais vendido: R$ " + maisVendido[0] + ", Posição no vetor: " + maisVendido[1]);
    }

    public static double valorTotalVendas(double[] valorProdutos, int[] quantProdutos) {
        double valorTotal = 0;
        for (int i = 0; i < valorProdutos.length; i++) {
            valorTotal += valorProdutos[i] + quantProdutos[i];
        }
        return valorTotal;
    }

    public static double[] produtoMaisVendido(double[] valorProdutos, int[] quantProdutos) {
        int quan = 0;
        double valor = 0;
        int index = 0;
        for (int i = 0; i < quantProdutos.length; i++) {
            if (quantProdutos[i] > quan) {
                quan = quantProdutos[i];
                index = i;
                valor = valorProdutos[i];
            }
        }
        return new double[]{valor, index};
    }

    public static void gerarRelatorio(double[] valorProdutos, int[] quantProdutos) {
        for (int i = 0; i < valorProdutos.length; i++) {
            System.out.println("Produto " + (i + 1) + ": " + "Quantidade vendida: " + quantProdutos[i]
                    + ", Valor unitário: R$ " + valorProdutos[i] + ", Valor total: R$ " + valorProdutos[i] * quantProdutos[i] );
        }
    }
}
