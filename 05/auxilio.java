package trab;

import java.util.Scanner;
import java.time.LocalDate;

public class auxilio {
    static double valorTotal = 0;
    static int totalBeneficiarios = 0;
    static double maiorBeneficiario1 = 0;
    static double maiorBeneficiario2 = 0;
    static String nomeMaiorBeneficiario1 = " ";
    static String nomeMaiorBeneficiario2 = " ";
    static double tempoMaiorBeneficiario1 = 0;
    static double tempoMaiorBeneficiario2 = 0;
    static String tempoNomeMaiorBeneficiario1 = " ";
    static String tempoNomeMaiorBeneficiario2 = " ";

    public static void main(String[] args) {
        String nomeCompleto, dataNascimento, categoria, estado;
        int mesesDeAuxilio, anoNascimento, tempoBeneficio;
        int numFuncionarios = 0, mesesDesempregado = 0, totalUsuarios = 0;
        double valorBeneficio;
        char aposentado;

        Scanner t = new Scanner(System.in);

        char opcao = 'S';
        while (opcao == 'S') {
            System.out.println("Nome Completo: ");
            nomeCompleto = t.nextLine();
            System.out.println("Data de Nascimento(Dia/Mês/Ano): ");
            dataNascimento = t.nextLine();
            anoNascimento = Integer.parseInt(dataNascimento.substring(dataNascimento.lastIndexOf('/') + 1));
            System.out.println("Valor do benefício: ");
            valorBeneficio = t.nextDouble();
            while (true) {
                System.out.println("Tempo do benefício em meses: ");
                tempoBeneficio = t.nextInt();
                if (tempoBeneficio >= 2 && tempoBeneficio <= 12) {
                    break;
                } else {
                    System.out.println("O tempo de benefício deve ser de no mínimo 2 meses até no máximo 12 meses");
                }
            }
            t.nextLine(); // Se não colocar ele pula o proximo nextLine()

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
            t.nextLine(); // Se não colocar ele pula o proximo nextLine()
            System.out.println("Estado(UF): ");
            estado = t.nextLine().toUpperCase();

            if (maiorDe18(anoNascimento)){
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

                tempoBeneficio = calcularMesesDeAuxilio(categoria, anoNascimento, tempoBeneficio);
                System.out.println(calcularAuxilio(nomeCompleto, valorBeneficio, categoria, numFuncionarios, estado, mesesDesempregado, tempoBeneficio));
                if (categoria.equals("empregador")) {
                    System.out.println("O tempo de benefício será de " + tempoBeneficio + " meses porque é empregador");
                } else if (categoria.equals("empregado")) {
                    System.out.println("O tempo de benefício será de " + tempoBeneficio + " meses porque é empregado e tem mais de 50 anos");
                } else {
                    System.out.println("O tempo de benefício será de " + tempoBeneficio + " meses");
                }
            } else {
                System.out.println("É menor de 18 anos e não pode receber o benefício");
            }
            totalUsuarios += 1;
            System.out.println("Deseja informar um novo beneficiário(S/N)? ");
            opcao = t.nextLine().toUpperCase().charAt(0);
        }
        System.out.println("Total de usúarios: " + totalUsuarios);
        System.out.println("Total de beneficiários: " + totalBeneficiarios);
        System.out.println("Total de valor concedido: R$ " + valorTotal);
        System.out.println("Nome dos beneficiários que receberam o maior valor: " + nomeMaiorBeneficiario1 + " e " + nomeMaiorBeneficiario2);
        System.out.println("Nome dos beneficiários que receberam por mais tempo: " + tempoNomeMaiorBeneficiario1 + " e " + tempoNomeMaiorBeneficiario2);
    }

    public static String calcularAuxilio(String nomeCompleto, double valorBeneficio, String categoria,
                                         int numFuncionarios, String estado, int mesesDesempregado, int tempoBeneficio) {
        switch (categoria) {
            case "empregado":
                if (valorBeneficio >= 1000 && valorBeneficio <= 1800) {
                    valorBeneficio = moraEmUF(valorBeneficio, estado);
                    maiorBeneficiario(valorBeneficio * tempoBeneficio, nomeCompleto);
                    maiorTempoDeBeneficio(tempoBeneficio, nomeCompleto);
                    valorTotal += valorBeneficio * tempoBeneficio;
                    totalBeneficiarios += 1;
                    return "Vai receber o benefício de R$ " + valorBeneficio;
                } else {
                    return "É preciso recadastrar o usúario, o valor do benefício do empregado deve ser entre R$ 1000 e R$ 1800";
                }
            case "empregador":
                valorBeneficio += 200 * numFuncionarios;
                valorBeneficio = moraEmUF(valorBeneficio, estado);
                maiorBeneficiario(valorBeneficio * tempoBeneficio, nomeCompleto);
                maiorTempoDeBeneficio(tempoBeneficio, nomeCompleto);
                valorTotal += valorBeneficio * tempoBeneficio;
                totalBeneficiarios += 1;
                return "Vai receber o benefício de R$ " + valorBeneficio;
            case "desempregado":
                if (valorBeneficio >= 1500 && valorBeneficio <= 2300) {
                    if (mesesDesempregado < 6) {
                        valorBeneficio -= (valorBeneficio * 0.1);
                    }
                    valorBeneficio = moraEmUF(valorBeneficio, estado);
                    maiorBeneficiario(valorBeneficio * tempoBeneficio, nomeCompleto);
                    maiorTempoDeBeneficio(tempoBeneficio, nomeCompleto);
                    valorTotal += valorBeneficio * tempoBeneficio;
                    totalBeneficiarios += 1;
                    return "Vai receber o benefício de R$ " + valorBeneficio;
                } else {
                    return "É preciso recadastrar o usúario, o valor do benefício do empregado deve ser entre R$ 1500 e R$ 2300";
                }
            default:
                return "Categoria inválida";
        }
    }

    public static int calcularMesesDeAuxilio(String categoria, int dataNascimento, int tempoBeneficio) {
        switch (categoria) {
            case "empregador":
                return 7;
            case "empregado":
                LocalDate dataAtual = LocalDate.now();
                if (dataNascimento - dataAtual.getYear() > 50) {
                    return 5;
                }
            default:
                return tempoBeneficio;
        }
    }

    public static boolean maiorDe18(int anoNascimento) {
        LocalDate dataAtual = LocalDate.now();
        if (dataAtual.getYear() - anoNascimento >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public static double moraEmUF(double valorBeneficio, String estado) {
        if (estado.equals("SC")) {
            return valorBeneficio * 1.05;
        } else if (estado.equals("PA")) {
            return valorBeneficio * 1.09;
        } else {
            return valorBeneficio;
        }
    }

    public static void maiorBeneficiario(double valorBeneficio, String nomeCompleto) {
        if (valorBeneficio > maiorBeneficiario1) {
            if (maiorBeneficiario1 > maiorBeneficiario2) {
                nomeMaiorBeneficiario2 = nomeMaiorBeneficiario1;
                maiorBeneficiario2 = maiorBeneficiario1;
            }
            nomeMaiorBeneficiario1 = nomeCompleto;
            maiorBeneficiario1 = valorBeneficio;
        } else if (valorBeneficio > maiorBeneficiario2) {
            maiorBeneficiario2 = valorBeneficio;
            nomeMaiorBeneficiario2 = nomeCompleto;
        }
    }

    public static void maiorTempoDeBeneficio(int tempoBeneficio, String nomeCompleto) {
        if (tempoBeneficio > tempoMaiorBeneficiario1) {
            if (tempoMaiorBeneficiario1 > tempoMaiorBeneficiario2) {
                tempoNomeMaiorBeneficiario2 = tempoNomeMaiorBeneficiario1;
                tempoMaiorBeneficiario2 = tempoMaiorBeneficiario1;
            }
            tempoNomeMaiorBeneficiario1 = nomeCompleto;
            tempoMaiorBeneficiario1 = tempoBeneficio;
        } else if (tempoBeneficio > tempoMaiorBeneficiario2) {
            tempoMaiorBeneficiario2 = tempoBeneficio;
            tempoNomeMaiorBeneficiario2 = nomeCompleto;
        }
    }
}
