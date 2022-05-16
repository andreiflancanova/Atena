package Pessoal_Java;

import java.util.Scanner;
import java.io.IOException;



public class Principal {
	
	
	public static void cls(){
		for (int i=0;i<40;i++) {
			System.out.println("");
		}
	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Aluno[] aluno = new Aluno[40]; 	
		
		int contAluno=0;
		char op;
		int registro = 101; 
		
		try (Scanner leia = new Scanner(System.in)) {
			do {
				
				System.out.println("[1] - Cadastrar aluno.");
				System.out.println("[2] - Pesquisar aluno.");
				System.out.println("[3] - Lançamento das notas de um prova.");
				System.out.println("[4] - Alterar nota de um aluno específico.");
				System.out.println("[5] - Listar notas por Alunos.");
				System.out.println("[6] - Listar notas por Provas.");
				System.out.println("-----\n[0] - Encerrar o programa.");
				
				//todo menu.
				op = leia.next().charAt(0);
				
				switch(op){
					case '1'://Cadastrar aluno
						cls();
						String nome;
						String RA = String.valueOf(registro);
						System.out.println("Insira o nome do Aluno: ");
						nome = leia.next();
						
						aluno[contAluno] = new Aluno(nome,RA);
						
						contAluno++;
						registro++;
						break;
						
					case '2'://Pesquisar Aluno
						cls();
						String identificacao;
						String pesquisa;
						System.out.println("Insira o Nome do Aluno ou RA.");
						identificacao = leia.next();
						
						//pesquisa por nome
						for(int i=0; i<contAluno; i++) {
							pesquisa = aluno[i].pesquisaNome();
							
							if (identificacao.equals(pesquisa)){
								aluno[i].imprimirPesquisa();
								aluno[i].imprimirNota();
							}
						}
						
						//pesquisa por RA.
						for(int i=0; i<contAluno; i++) {
							pesquisa = aluno[i].pesquisaRA();
							
							if (identificacao.equals(pesquisa)){
								aluno[i].imprimirPesquisa();
								aluno[i].imprimirNota();
							}
						}
						break;
						
					case '3'://Cadastrar nota da disciplina
						cls();
						String nomeProva;
						System.out.println("Insira o nome da disciplina: ");
						nomeProva = leia.next();
						
						float nota;
						//Imprimir todos os alunos, e solicitar a nota dos mesmos.
						for(int i=0; i<contAluno; i++) {
							
							aluno[i].imprimirPesquisa();
							System.out.println("Insira o nota: ");
							nota = leia.nextFloat();
							
							aluno[i].lancarNota(nomeProva, nota);
						}	
						break;
						
					case '4':
						// Alterar nota de um aluno especifico
						String identificacao1;
						
						//Recebendo identificacao do aluno
						System.out.println("Insira o Nome do Aluno ou RA.");
						identificacao1 = leia.next();
						
						//Recebendo nome da prova e nota da prova
						String nomeProva1, notaProva1, pesquisa1, pesquisa2;
						
						
						//Encontrando aluno pelo RA e Nome
						for(int i=0; i<contAluno; i++) {
							pesquisa1 = aluno[i].pesquisaRA();
							pesquisa2 = aluno[i].pesquisaNome();
							
							if (identificacao1.equals(pesquisa1)){
								
								//Recebendo nome da prova e nota da prova
								System.out.println("Qual o nome da prova? ");
								nomeProva1 = leia.next();
								System.out.println("Qual a nota da prova? ");
								notaProva1 = leia.next();
								
								//Substituindo a nota
								int ra = Integer.parseInt(pesquisa1);
								aluno[i].substituirNota(nomeProva1, notaProva1, ra);
							
							}
							if (identificacao1.equals(pesquisa2)){
								
								//Recebendo nome da prova e nota da prova
								System.out.println("Qual o nome da prova? ");
								nomeProva1 = leia.next();
								System.out.println("Qual a nota da prova? ");
								notaProva1 = leia.next();
								
								//Substituindo a nota
								int ra = Integer.parseInt(aluno[i].getCodigo());
								aluno[i].substituirNota(nomeProva1, notaProva1, ra);
							}
						}
						
						
						
						break;
						
					case '5':
						cls();
						for (int i = 0; i < contAluno; i++) {
							aluno[i].todasNotasAluno();
							System.out.println("");
						}
						
						break;	
					
					case '6':
						
						
						break;
						
					default:
						cls();
						System.out.println("Opção Inválida. Por Favor, digite novamente.");

				}

			}while(op!=0);
		}

	}

}