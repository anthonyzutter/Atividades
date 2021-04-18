package ex;

import java.time.LocalDate;

public class Ex1 {
    public static void main(String[] args) {
        LocalDate data = LocalDate.now();
        int anoAtual = data.getYear();
        int anoInicio = 2015;
        double salario = 1000;
        double aumento = 1.5;

        while (anoInicio < anoAtual) {
            salario *= aumento / 100 + 1;
            System.out.println("Aumento de " + aumento + "% Novo salário: R$" + salario);
            aumento *= 2;
            anoInicio++;
        }
        System.out.println();
    }
}
