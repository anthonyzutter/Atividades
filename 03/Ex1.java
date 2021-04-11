package ex;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o modelo do veículo: ");
        String modelo = teclado.nextLine();
        System.out.println("Digite a marca do veículo: ");
        String marca = teclado.nextLine().toLowerCase();
        System.out.println("Digite o custo de fabricação do veículo: ");
        double custo = teclado.nextDouble();
        System.out.println("O carro " + modelo + " da marca " + marca + " será vendido por R$ " + preçoVenda(marca, custo));

    }
    public static double preçoVenda(String marca, double custo){
        if (marca.equals("chevrolet")){
            return custo * 1.30;
        } else if (marca.equals("renault")){
            return custo * 1.40;
        } else if (marca.equals("citroen")){
            return custo * 1.42;
        } else {
            return custo * 1.49;
        }
    }
}
