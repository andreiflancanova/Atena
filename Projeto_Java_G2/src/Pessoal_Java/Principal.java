package Pessoal_Java;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;



public class Principal {
	
	
	public static void cls(){
		for (int i=0;i<40;i++) {
			System.out.println("");
		}
	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ArrayList<String> disciplinas = new ArrayList<>();
		
		Aluno[] aluno = new Aluno[40]; 	
		
		int contAluno=0;
		char op;
		int registro = 101; 
		
		//String pular;
		
		try (Scanner leia = new Scanner(System.in)) {
			do {
				System.out.println("-----------------------------------------");
				System.out.println("[1] - Cadastrar um novo alune.");
				System.out.println("[2] - Pesquisar informações do estudante.");
				System.out.println("[3] - Lançar notas de uma prova.");
				System.out.println("[4] - Alterar a nota de um alune específico.");
				System.out.println("[5] - Listar todas as notas de um alune.");
				System.out.println("[6] - Listar todas as notas de uma prova.");
				System.out.println("[0] - Encerrar o programa.");
				System.out.println("-----------------------------------------\n");
				
				//todo menu.
				op = leia.next().charAt(0);
				switch(op){
					case '1'://Cadastrar aluno
						leia.nextLine();
						cls();
						System.out.println();	
						String RA = String.valueOf(registro);
						System.out.println("Insira o nome do Alune: ");
						String nome = leia.nextLine();
						
						aluno[contAluno] = new Aluno(nome,RA);
						
						contAluno++;
						registro++;
						break;
						
					case '2'://Pesquisar Aluno
						leia.nextLine();
						cls();
						String pesquisa;
						System.out.println("Insira o Nome ou Ra do estudante: ");
						String identificacao = leia.nextLine();
						
						//pesquisa por nome
						for(int i=0; i<contAluno; i++) {
							pesquisa = aluno[i].getNomeAluno();
							
							if (identificacao.equals(pesquisa)){
								aluno[i].imprimirPesquisa();
								aluno[i].imprimirNota();
							}
						}
						
						//pesquisa por RA.
						for(int i=0; i<contAluno; i++) {
							pesquisa = aluno[i].getCodigo();
							
							if (identificacao.equals(pesquisa)){
								aluno[i].imprimirPesquisa();
								aluno[i].imprimirNota();
							}
						}
						break;
						
					case '3'://Cadastrar nota da disciplina
						leia.nextLine();
						cls();
						System.out.println("Insira o nome da disciplina: ");
						String nomeProva = leia.nextLine();
						disciplinas.add(nomeProva);
						
						
						
						//Imprimir todos os alunos, e solicitar a nota dos mesmos.
						for(int i=0; i<contAluno; i++) {
							
							aluno[i].imprimirPesquisa();
							
							boolean aprovado = true;
							
							do {
								try {
									System.out.println("Insira a nota: ");
									float nota = leia.nextFloat();
									aluno[i].lancarNota(nomeProva, nota);
									aprovado = false;	
								}
								catch(InputMismatchException inputMismatchException){
									System.out.println("------");
									System.err.println("Erro: entre com um número válido.");
									System.out.println("Exemplo: 6,7.\n------");
									leia.nextLine();
								}
							}while(aprovado);
						}	
						break;
						
					case '4'://Alterar nota de um aluno especifico
						//Recebendo identificacao do aluno
						leia.nextLine();
						System.out.println("Insira o Nome ou RA do estudante.");
						String identificacao1 = leia.next();
						
						//Recebendo nome da prova e nota da prova
						String nomeProva1, pesquisa1, pesquisa2;
						float notaProva1;
						int indiceProva = 0;
						
						//Encontrando aluno pelo RA ou Nome
						for(int i=0; i<contAluno; i++) {
							pesquisa1 = aluno[i].getCodigo();
							pesquisa2 = aluno[i].getNomeAluno();
							
							if (identificacao1.equals(pesquisa1)){//RA
								leia.nextLine();
								//Recebendo nome da prova e nova nota da prova
								System.out.println("Qual o nome da prova? ");
								nomeProva1 = leia.nextLine();
								
								for(int j=0; j<aluno[i].getQuantidadeProva();j++) {
									if(nomeProva1.equals(aluno[i].getProva()[j][0])){
										indiceProva=j;
									}
								}
								
								System.out.println("Qual a nota da prova? ");
								notaProva1 = leia.nextFloat();
								
								//Substituindo a nota
								aluno[i].substituirNota(notaProva1,indiceProva);
							
							}
							if (identificacao1.equals(pesquisa2)){//Nome
								leia.nextLine();
								//Recebendo nome da prova e nova nota da prova
								System.out.println("Qual o nome da prova? ");
								nomeProva1 = leia.nextLine();
								
								for(int j=0; j<aluno[i].getQuantidadeProva();j++) {
									if(nomeProva1.equals(aluno[i].getProva()[j][0])){
										indiceProva=j;
									}
								}
								
								System.out.println("Qual a nota da prova? ");
								notaProva1 = leia.nextFloat();
								
								//Substituindo a nota
								aluno[i].substituirNota(notaProva1,indiceProva);
							}
						}
						break;
						
					case '5'://Listagem de notas tendo-se como tópico principal os Alunos.
						leia.nextLine();
						cls();
						for (int i = 0; i < contAluno; i++) {
							aluno[i].todasNotasAluno();	
						}
						break;	
					
					case '6'://Listagem de notas tendo-se como tópico principal as Disciplinas.
						leia.nextLine();
						cls();
						for(String elementos: disciplinas) {
							System.out.println("Disciplinas: " + elementos);
							for(int i = 0; i < contAluno; i++) {
								for(int j = 0; j < aluno[i].getQuantidadeProva(); j++) {
									if(elementos.equals(aluno[i].getProva()[j][0])) {
										System.out.println("Alune: " + aluno[i].getNomeAluno() + "\tNota: " + aluno[i].getProva()[j][1]);
									}
								}
							}
							System.out.println("");
						}
						break;
					
					case '0':
						leia.nextLine();
						cls();System.out.println("Programa encerrado...");
						break;
					default:
						leia.nextLine();
						cls();
						System.err.println("! Opção Inválida. Por Favor, digite novamente. !");
						break;
						
				}

			}while(op!='0');
		}

	}

}

