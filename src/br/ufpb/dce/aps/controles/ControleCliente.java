package br.ufpb.dce.aps.controles;

import java.util.LinkedList;
import java.util.List;

import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.entidades.Endereco;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;

public class ControleCliente {

	private List<Cliente> clientes = new LinkedList<Cliente>();

	public void cadastrarCliente(Cliente c) throws ClienteJaCadastradoException {

		// se lista vazia ou cliente não existente
		if ((this.clientes.isEmpty()) ||  (c.getCPF() != this.buscarCliente(c.getCPF()).getCPF())) 
			this.clientes.add(c);	 

		// se ja existe
		else
			throw new ClienteJaCadastradoException("Cliente exception");

	}

	public Cliente buscarCliente(String cpf) {
		for (Cliente p : clientes)
			if (p.getCPF() == cpf)
				return p;
		return null;
	}

	public boolean removerCliente(String CPF) {
		Cliente c = this.buscarCliente(CPF);
		if (c != null) {
			return this.clientes.remove(c);
		}
		return false;
	}

	public List<Cliente> listarClientes() {
		if (!this.clientes.isEmpty())
			return this.clientes;
		return null;
	}


}
