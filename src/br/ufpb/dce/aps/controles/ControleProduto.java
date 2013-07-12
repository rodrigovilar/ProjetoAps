package br.ufpb.dce.aps.controles;

import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.List;

import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;
import br.ufpb.dce.aps.exception.ValorInvalidoException;

public class ControleProduto {

	private List<Produto> estoque = new LinkedList<Produto>();
	private Produto p;


	public void cadastrarProduto(String nome, int codigo, float preco)
			throws ProdutoJaCadastradoException, ValorInvalidoException {
		p = new Produto();

		if(isValido(nome, codigo, preco)) {
			// se lista vazia
			if (this.estoque.isEmpty()) {
				p.setNome(nome);
				p.setPreco(preco);
				p.setCodigo(codigo);
				this.estoque.add(p);			

				// se lista não vazia, cheque se os produtos já existente
			} else if (codigo != this.buscarProduto(codigo).getCodigo()) {
				p.setNome(nome);
				p.setPreco(preco);
				p.setCodigo(codigo);			
				this.estoque.add(p);

				// se produto ja existe
			} else 
				throw new ProdutoJaCadastradoException("Produto Exception");

		}else throw new ValorInvalidoException("Valor Inesperado");

	}

	public boolean removerProduto(int codigo) {
		Produto p = this.buscarProduto(codigo);
		if (p != null) {
			this.estoque.remove(p);			
			return true;
		}
		return false;
	}



	public Produto buscarProduto(int codigo) throws ValorInvalidoException{
		if(!this.isValido(codigo))
			throw new ValorInvalidoException("valor invalido");
		else{
			for (Produto p : estoque)
				if (p.getCodigo() == codigo)
					return p;
			return null;
		}
	}
	public int getNumeroDeProdutos(){
		return this.estoque.size();
	}

	public List<Produto> exibirEstoqueDeProdutos() {
		if(!this.estoque.isEmpty())
			return this.estoque;
		return null;
	}


	private boolean isValido(String nome, int codigo, float preco) {
		// testador de entrada de parâmetros
		String cod = String.valueOf(codigo);
		String prec = String.valueOf(preco);

		if((Pattern.matches("[a-zA-Z]", nome)) && (Pattern.matches("[0-9]", cod)) && 
				(Pattern.matches("^[0-9]",prec)))
			return true;
		return false;
	}

	private boolean isValido(int codigo){
		// testador de entrada de parâmetros para busca e remoção
		String cod = String.valueOf(codigo);
		if((Pattern.matches("[0-9]", cod)))
			return true;
		return false;

	}
}
