package br.ufpb.dce.aps.controles;
import java.util.LinkedList;
import java.util.List;

import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.entidades.Documento;
import br.ufpb.dce.aps.entidades.Endereco;
import br.ufpb.dce.aps.entidades.Produto;

public class ControleCliente {

	private List<Cliente> clientes = new LinkedList<Cliente>();
	private Cliente p;
	private Endereco e;


	public void cadastrarCliente(int numero, String nome, String rua, String bairro, int telefone, String referencia, String cpf) {
		p = new Cliente();
		e = new Endereco(numero, rua, bairro, referencia);
		// se lista vazia
		if (null == this.buscarCliente(cpf)) {
			p.setNome(nome);
			p.setEndereco(e);
			p.setCPF(cpf);
			this.clientes.add(p);
	}else if (cpf != this.buscarCliente(cpf).getCpf()) {
		p.setNome(nome);
		p.setEndereco(e);
		p.setCPF(cpf);
		this.clientes.add(p);
	}

	
	}
	public Cliente buscarCliente(String cpf) {
		for (Cliente p : clientes)
			if (p.getCpf() == cpf)
				return p;
		return null;
	}

	

	public void exibirDados(Cliente cliente) {

	}

	
		
	}

