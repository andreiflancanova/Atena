package Pessoal_Java;

public class Aluno {
	//Atributos
	private String nomeAluno;
	private String codigo;
	
	//Construtor
	public Aluno(String nome, String codigo){
		
		this.nomeAluno = nome;
		this.codigo = codigo;
		
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
	
}
