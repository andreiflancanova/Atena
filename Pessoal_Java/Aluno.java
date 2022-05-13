package Pessoal_Java;

public class Aluno {
	//Atributos
	private String nomeAluno;
	private String codigo;
	private String[][] prova = new String[4][2];
	private float nota;
	private int quantidadeProva=0;
	
	//Construtor
	public Aluno(String nome, String codigo){
		super();
		this.nomeAluno = nome;
		this.codigo = codigo;
		
	}
	
	public void lancarNota(String nomeProva, float notaProva){
		this.prova[quantidadeProva][0] = nomeProva;
		this.prova[quantidadeProva][1] = String.valueOf(notaProva);		
		quantidadeProva++;
	}
		
	public String pesquisaNome() {
		return nomeAluno;		
	}
	
	public String pesquisaRA() {
		return codigo;		
	}
	
	public void imprimirPesquisa() {
		System.out.println("Nome do Aluno: "+nomeAluno+"\t\tRA: "+codigo);
	}

	public void imprimirNota() {
		for(int i=0; i<quantidadeProva; i++) {
			System.out.println("\tdisplicina: "+prova[i][0]+"\t\tnota: "+prova[i][1]);
		}
	}

	//get & set
	
	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String[][] getProva() {
		return prova;
	}

	public void setProva(String[][] prova) {
		this.prova = prova;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public int getQuantidadeProva() {
		return quantidadeProva;
	}

	public void setQuantidadeProva(int quantidadeProva) {
		this.quantidadeProva = quantidadeProva;
	}

}
