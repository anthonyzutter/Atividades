package ex;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome do funcionário: ");
        String nome = teclado.next();
        System.out.println("Digite o número de horas trabalhadas: ");
        int horas = teclado.nextInt();
        System.out.println("Digite o número de dependentes: ");
        int dependentes = teclado.nextInt();
        int bruto = horas * 32 + dependentes * 40;
        double inns = bruto * 0.085;
        double ir = bruto * 0.05;
        System.out.println("Sálario bruto: " + bruto);
        System.out.println("Valor do desconto INSS: " + inns);
        System.out.println("Valor do desconto IR: " + ir);
        System.out.println("Valor sálario liquido: " + (bruto - inns - ir));
    }
}
