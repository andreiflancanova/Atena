package Pessoal_Java;

import java.util.Scanner;
import java.io.IOException;



public class Principal {
	
	/*
	public static void cls(){
		for (int i=0;i<40;i++) {
			System.out.println("");
		}
	}*/
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Aluno[] aluno = new Aluno[40]; 	
		
		int contAluno=0,op;
		int registro = 101; 
		
		String pular;
		
		Scanner leia = new Scanner(System.in);
		
		do {
			
			System.out.println("[1] - Cadastrar aluno.");
			System.out.println("[2] - Pesquisar aluno.");
			System.out.println("[3] - Lançamento das notas de um prova.");
			System.out.println("[4] - Alterar nota de um aluno específico.");
			System.out.println("[5] - Listar notas por Alunos.");
			System.out.println("[6] - Listar notas por Provas.");
			System.out.println("-----\n[0] - Encerrar o programa.");
			
			//todo menu.
			op = leia.nextInt();
			
			
			if(op == 1) { //Cadastrar aluno.x
				String nome;
				String RA = String.valueOf(registro);
				System.out.println("Insira o nome do Aluno: ");
				nome = leia.next();
				
				
				aluno[contAluno] = new Aluno(nome,RA);
				/*aluno[0] = new Aluno("Gabi","101");
				aluno[1] = new Aluno("Joao","102");
				aluno[2] = new Aluno("Cristiano","103");*/
				
				contAluno++;
				registro++;
				//contAluno = 2;
			}
			
			if(op == 2) { 
				String identificacao;
				String pesquisa;
				System.out.println("Insira o Nome do Aluno ou RA.");
				identificacao = leia.next();
				
				//pesquisa por nome
				for(int i=0; i<contAluno; i++) {
					pesquisa = aluno[i].pesquisaNome();
					
					if (identificacao.equals(pesquisa)){
						aluno[i].imprimirPesquisa();
					}
				}
				
				//pesquisa por RA.
				for(int i=0; i<contAluno; i++) {
					pesquisa = aluno[i].pesquisaRA();
					
					if (identificacao.equals(pesquisa)){
						aluno[i].imprimirPesquisa();
					}
				}
			}
			
			//cls();
		}while(op!=0);

	}

}

