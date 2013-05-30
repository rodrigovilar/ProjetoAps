package aps.padrao;

public abstract class Produto {
	private int codigo;
	public Produto(int c){
		this.setCodigo(c);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
