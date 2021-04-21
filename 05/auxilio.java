package trab;

import java.util.Scanner;
import java.time.LocalDate;

public class auxilio {
    private static double valorTotal = 0;
    public static void main(String[] args) {
        String nomeCompleto, categoria, estado;
        int mesesDeAuxilio, dataNascimento;
        int numFuncionarios = 0, mesesDesempregado = 0, totalUsuarios = 0, totalBeneficiarios = 0;
        double valorBeneficio;
        char aposentado;
        String data;

        Scanner t = new Scanner(System.in);

        char opcao = 'S';
        while (opcao == 'S') {
            System.out.println("Nome Completo: ");
            nomeCompleto = t.nextLine();
            System.out.println("Data de Nascimento(Dia/Mês/Ano): ");
            data = t.nextLine();
            // Pega o ano
            dataNascimento = Integer.parseInt(data.substring(data.lastIndexOf('/') + 1));
            System.out.println("Valor do benefício: ");
            valorBeneficio = t.nextDouble();
            t.nextLine(); // Se não colocar isso ele pula o proximo nextLine()

            while (true) {
                System.out.println("Categoria(Empregado, Empregador ou Desempregado):");
                categoria = t.nextLine().toLowerCase();

                switch (categoria) {
                    case "empregado":
                        System.out.println("É aposentado(S/N)? ");
                        aposentado = t.next().toUpperCase().charAt(0);
                        break;
                    case "empregador":
                        System.out.println("Número de funcionários: ");
                        numFuncionarios = t.nextInt();
                        break;
                    case "desempregado":
                        System.out.println("A quantos meses está desempregado? ");
                        mesesDesempregado = t.nextInt();
                        break;
                    default:
                        System.out.println("Categoria inválida");
                }
                if (categoria.equals("empregado") || categoria.equals("empregador") || categoria.equals("desempregado")){
                    break;
                }
            }
            t.nextLine(); // Se não colocar isso ele pula o proximo nextLine()
            System.out.println("Estado(UF): ");
            estado = t.nextLine().toUpperCase();

            LocalDate dataAtual = LocalDate.now();
            if (dataAtual.getYear() - dataNascimento >= 18){
                System.out.println("Nome: " + nomeCompleto);
                System.out.println("Data de nascimento: " + dataNascimento);
                System.out.println("Categoria: " + categoria);

                if (estado.equals("SC")) {
                    System.out.println("Usuário mora em Santa Catarina e terá um acréscimo de 5%");
                } else if (estado.equals("PA")) {
                    System.out.println("Usuário mora no Pará e terá um acréscimo de 9%");
                }
                if (categoria.equals("desempregado")) {
                    if (mesesDesempregado < 6) {
                        System.out.println("Está menos de 6 meses desempregado e terá redução de 10%");
                    }
                }

                System.out.println(calcularAuxilio(valorBeneficio, categoria, numFuncionarios, estado, dataNascimento));
                mesesDeAuxilio = calcularMesesDeAuxilio(categoria, dataNascimento);
                if (mesesDeAuxilio > 0) {
                    System.out.println("Receberá o benefício por " + mesesDeAuxilio + " meses");
                } else {
                    System.out.println("Receberá o benefício por no mínimo 2 até no máximo 12 meses");
                }

                totalBeneficiarios += 1;
            } else {
                System.out.println("É menor de 18 anos e não pode receber o benefício");
            }
            totalUsuarios += 1;
            System.out.println("Deseja informar um novo beneficiário(S/N)? ");
            opcao = t.next().toUpperCase().charAt(0);
            t.nextLine();
        }
        System.out.println("Total de usúarios: " + totalUsuarios);
        System.out.println("Total de beneficiários: " + totalBeneficiarios);
        System.out.println("Total de valor concedido: R$ " + valorTotal);
    }

    public static String calcularAuxilio(double valorBeneficio, String categoria,
                                         int numFuncionarios, String estado, int mesesDesempregado) {
        switch (categoria){
            case "empregado":
                if (valorBeneficio >= 1000 && valorBeneficio <= 1800){
                    valorBeneficio = moraEmUF(valorBeneficio, estado);
                    valorTotal += valorBeneficio;
                    return "Vai receber o benefício de R$ " + valorBeneficio;
                } else {
                    return "O valor do benefício do empregado deve ser entre R$ 1000 e R$ 1800";
                }
            case "empregador":
                valorBeneficio += 200 * numFuncionarios;
                valorBeneficio = moraEmUF(valorBeneficio, estado);
                valorTotal += valorBeneficio;
                return "Vai receber o benefício de R$ " + valorBeneficio;
            case "desempregado":
                if (valorBeneficio >= 1500 && valorBeneficio <= 2300){
                    if (mesesDesempregado < 6){
                        valorBeneficio = valorBeneficio - (valorBeneficio * 0.1);
                    }
                    valorBeneficio = moraEmUF(valorBeneficio, estado);
                    valorTotal += valorBeneficio;
                    return "Vai receber o benefício de R$ " + valorBeneficio;
                } else {
                    return "O valor do benefício do empregado deve ser entre R$ 1500 e R$ 2300";
                }
            default:
                return "Categoria inválida";
        }
    }

    public static int calcularMesesDeAuxilio(String categoria, int dataNascimento) {
        switch (categoria){
            case "empregador":
                return 7;
            case "empregado":
                LocalDate dataAtual = LocalDate.now();
                if (dataNascimento - dataAtual.getYear() > 50) {
                    return 5;
                }
            default:
                return 0;
        }
    }

    public static double moraEmUF(double valorBeneficio, String estado) {
        if (estado.equals("SC")) {
            return valorBeneficio * 1.05;
        } else if (estado.equals("PA")){
            return valorBeneficio * 1.09;
        } else {
            return valorBeneficio;
        }
    }
}