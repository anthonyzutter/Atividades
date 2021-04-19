package ex;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        final int valorHora = 30;
        int codigo, horas;
        int numProfsMasculino = 0, numProfsFeminino = 0, totalSalarioLiquidoMasculino= 0, totalSalarioLiquidoFeminino = 0;
        double salarioBruto, salarioLiquido;
        char sexo;
        String listagem = "";

        Scanner t = new Scanner(System.in);

        while (true) {
            System.out.println("Código: ");
            codigo = t.nextInt();
            if (codigo == 99999) {
                break;
            } else {
                System.out.println("Sexo: ");
                sexo = t.next().toUpperCase().charAt(0);
                System.out.println("Horas mensais: ");
                horas = t.nextInt();
                salarioBruto = horas * valorHora;
                switch (sexo) {
                    case 'M':
                        salarioLiquido = salarioBruto - (salarioBruto * 0.1);
                        listagem = listagem.concat("Código: " + codigo + ", Salário bruto: " + salarioBruto  + ", Salário líquito: " + salarioLiquido + "\n");
                        totalSalarioLiquidoMasculino += salarioLiquido;
                        numProfsMasculino++;
                        break;
                    case 'F':
                        salarioLiquido = salarioBruto - (salarioBruto * 0.05);
                        listagem = listagem.concat("Código: " + codigo + ", Salário bruto: " + salarioBruto +
                                ", Salário líquito: " + salarioLiquido + "\n");
                        totalSalarioLiquidoFeminino += salarioLiquido;
                        numProfsFeminino++;
                        break;
                    default:
                        System.out.println("Valor de sexo invalido");
                }
            }
        }
        if (numProfsMasculino > 0) {
            System.out.println("Média sálario liquido professores: " + totalSalarioLiquidoMasculino / numProfsMasculino);
        }
        if (numProfsFeminino > 0) {
            System.out.println("Média sálario liquido professoras: " + totalSalarioLiquidoFeminino / numProfsFeminino);
        }
        System.out.println(listagem);
    }
}