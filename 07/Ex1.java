package ex_vetores;

import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
	    String[][] pacientes = new String[2][3]; 
	    String nome, idade, descricao;
	    int index;
	    
	    Scanner tc = new Scanner(System.in);
	    
	    int opcao = 0;
	    while (opcao != 3) {
	        System.out.println("1 - Incluir paciente, 2 - Atender paciente, 3 - Sair");
	        opcao = Integer.parseInt(tc.nextLine());
	        if (opcao == 1) {
	            System.out.println("Nome: ");
	            nome = tc.nextLine();
	            System.out.println("Idade: ");
	            idade = tc.nextLine();
	            System.out.println("Descrição: ");
	            descricao = tc.nextLine();
	            adicionarPaciente(pacientes, nome, idade, descricao);
	        } else if (opcao == 2) {
	            System.out.println("Qual paciente vai ser atendido? ");
	            index = tc.nextInt() + 1;
	            removerPaciente(pacientes, index);
	        }
	        System.out.println(pacientes[0][0]);
	    }
	}
	
	public static String[][] adicionarPaciente(String[][] pacientes, String nome, String idade, String descricao) {
	    for (int i = 0; i < pacientes.length; i++) {
	        if (pacientes[i][i] == null) {
	            pacientes[i][0] = nome;
	            pacientes[i][1] = idade;
	            pacientes[i][2] = descricao;
	            return pacientes;
	        }
	    }
	    System.out.println("Número máximo de pesssoas na fila");
	    return pacientes;
	}
	
	public static String[][] removerPaciente(String[][] pacientes, int index) {
	    String[][] pacientesAtualizados = new String[pacientes.length][3];
	    if (index > pacientes.length || index < 0) {
	        System.out.println("Paciente não encontrado");
	        return pacientes;
	    }
	    for (int i = 0; i < pacientes.length; i++) {
	        if (i == index) {
	            continue;
	        }
	        pacientesAtualizados[i] = pacientes[i];
	    }
	    return pacientesAtualizados;
	}
}

