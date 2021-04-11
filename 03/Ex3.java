package ex;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args){
        final double preçoGasolina = 4.30;
        final double preçoAlcool = 3.50;
        final double preçoDiesel = 3.90;

        Scanner teclado = new Scanner(System.in);
        System.out.println("Litros vendidos: ");
        int litros = teclado.nextInt();
        System.out.println("Tipo de combustível: ");
        String combustivel = teclado.next().toLowerCase();

        double preço = calcularPreço(litros, combustivel, preçoGasolina, preçoAlcool, preçoDiesel);
        System.out.println("O valor a ser pago por " + litros + " litros de " + combustivel + " é de R$" + preço);
    }
    public static double calcularPreço(int litros, String combustivel,
                                          double preçoGasolina, double preçoAlcool, double preçoDiesel){
        if (combustivel.equals("gasolina")){
            if (litros <= 10){
                return litros * (preçoGasolina - preçoGasolina * 0.06);
            } else {
                return litros * (preçoGasolina - preçoGasolina * 0.065);
            }
        } else if (combustivel.equals("alcool") || combustivel.equals("etanol")){
            if (litros <= 10){
                return litros * (preçoAlcool - preçoAlcool * 0.04);
            } else {
                return litros * (preçoAlcool - preçoAlcool * 0.05);
            }
        } else if (combustivel.equals("diesel")){
            if (litros <= 20){
                return litros * (preçoDiesel - preçoDiesel * 0.15);
            } else {
                return litros * (preçoDiesel - preçoDiesel * 0.20);
            }
        } else {
            return 0;
        }
    }
}
