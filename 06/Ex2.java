package ex_vetores;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        String[] carros = new String[5];
        double[] consumos = new double[5];

        for (int i = 0; i < carros.length; i++) {
            System.out.println("Modelo do carro " + (i+1) + ": ");
            carros[i] = tc.nextLine();
            System.out.println("Km por litro: ");
            consumos[i] = Double.parseDouble(tc.nextLine());
        }
        double maisEconomico = consumos[0];
        int maisEconomicoIndex = 0;
        for (int i = 0; i < carros.length; i++) {
            if (consumos[i] > maisEconomico) {
                maisEconomicoIndex = i;
                maisEconomico = consumos[i];
            }
            System.out.println(carros[i] + " consome " + (1000 / consumos[i]) + " litros de combustivel para 1.000 Km");
        }
        System.out.println("Carro mais econômico: " + carros[maisEconomicoIndex]);
    }
}
