package br.ufpb.dce.aps.controles;
import java.util.LinkedList;
import java.util.List;

import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.entidades.Documento;
import br.ufpb.dce.aps.entidades.Endereco;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;

public class ControleCliente {

	private List<Cliente> clientes = new LinkedList<Cliente>();
	private Cliente p;
	private Endereco e;


	public void cadastrarCliente(String numero, String nome, String rua, String bairro, 
			String telefone, String referencia, String cpf) throws ClienteJaCadastradoException{
		p = new Cliente();
		e = new Endereco(numero, rua, bairro, referencia);
		// se lista vazia
		if (null == this.buscarCliente(cpf)) {
			p.setNome(nome);
			p.setEndereco(e);
			p.setCPF(cpf);
			this.clientes.add(p);
			// se lista não vazia, descubra se o cliente ja existe
		}else if (cpf != this.buscarCliente(cpf).getCpf()) {
			p.setNome(nome);
			p.setEndereco(e);
			p.setCPF(cpf);
			this.clientes.add(p);
		}
		//se ja existe
		else throw new ClienteJaCadastradoException();


	}
	public Cliente buscarCliente(String cpf) {
		for (Cliente p : clientes)
			if (p.getCPF() == cpf)
				return p;
		return null;
	}



	public void exibirDados(Cliente cliente) {

	}



}

