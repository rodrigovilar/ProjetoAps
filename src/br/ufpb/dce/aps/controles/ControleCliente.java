package br.ufpb.dce.aps.controles;
import java.util.LinkedList;
import java.util.List;

import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.entidades.Endereco;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;

public class ControleCliente {

	private List<Cliente> clientes = new LinkedList<Cliente>();
	private Cliente c;
	private Endereco e;
	private int contadorDeClientes =0;


	public void cadastrarCliente(String numero, String nome, String rua, String bairro, 
			String telefone, String referencia, String cpf) throws ClienteJaCadastradoException{
		c = new Cliente();
		
		// se lista vazia
		if (null == this.buscarCliente(cpf)) {
			e = new Endereco(numero, rua, bairro, referencia);
			c.setNome(nome);
			c.setCPF(cpf);
			c.setTelefone(telefone);
			c.setEndereco(e);
			this.clientes.add(c);
			this.contadorDeClientes++;
			// se lista não vazia, descubra se o cliente ja existe
		}else if (cpf != this.buscarCliente(cpf).getCPF()) {
			e = new Endereco(numero, rua, bairro, referencia);
			c.setNome(nome);
			c.setCPF(cpf);
			c.setTelefone(telefone);
			c.setEndereco(e);
			this.clientes.add(c);
			this.contadorDeClientes++;
		}

		//se ja existe
		else throw new ClienteJaCadastradoException("Cliente exception");


	}
	
	public Cliente buscarCliente(String cpf) {
		for (Cliente p : clientes)
			if (p.getCPF() == cpf)
				return p;
		return null;
	}



	public boolean removerCliente(String CPF) {
		Cliente c = this.buscarCliente(CPF);
		if (c != null){
			this.clientes.remove(c);
			this.contadorDeClientes--;
			return true;			
		}
		return false;
	}
	
	public List<Cliente>listarClientes(){
		return this.clientes;
	}
	
	public int getNumeroDeClientes(){
		return this.contadorDeClientes;
	}



}

