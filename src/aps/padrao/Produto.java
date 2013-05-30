package aps.padrao;

public class Produto {
	private int			codigo;
	private String	nome;
	
	public Produto (int c, String nome){
		this.codigo = c;
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
