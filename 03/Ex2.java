package ex;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Número da conta: ");
        String conta = teclado.next();
        System.out.println("Saldo: ");
        double saldo = teclado.nextDouble();
        System.out.println("Débito: ");
        double debito = teclado.nextDouble();
        System.out.println("Crédito: ");
        double credito = teclado.nextDouble();

        double saldoAtual = calcularSaldo(saldo, debito, credito);
        System.out.println("O saldo atual é de R$ " + saldoAtual);
        System.out.println("O seu saldo é " + situacaoSaldo(saldoAtual));
    }
    public static double calcularSaldo(double saldo, double debito, double credito){
        return saldo - debito + credito;
    }
    public static String situacaoSaldo(double saldoAtual){
        if (saldoAtual >= 0){
            return "Positivo";
        } else {
            return "Negativo";
        }
    }
}
