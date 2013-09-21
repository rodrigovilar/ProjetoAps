package br.ufpb.dce.aps.controles;

import java.util.LinkedList;
import java.util.List;

import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.exception.CPFInvalidoException;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;
import br.ufpb.dce.aps.exception.ClienteNaoCadastradoException;

public class ControleCliente {

	public static final int TAMANHO_DO_CPF = 11;
	private List<Cliente> clientes = new LinkedList<Cliente>();

	public void cadastrarCliente(Cliente c)
			throws ClienteJaCadastradoException, CPFInvalidoException,
			ClienteNaoCadastradoException {

		// se lista vazia ou cliente não existente
		if (this.buscarCliente(c.getCPF()) == null)
			this.clientes.add(c);

		// se ja existe
		else
			throw new ClienteJaCadastradoException("Cliente exception");

	}

	public Cliente buscarCliente(String cpf) throws CPFInvalidoException,
	ClienteNaoCadastradoException {
		boolean teste = this.ehValido(cpf);
		if (!teste)
			throw new CPFInvalidoException("CPF inválido");
		else
			for (Cliente p : clientes)
				if (p.getCPF() == cpf)
					return p;
		return null;
	}

	public boolean removerCliente(String CPF) throws CPFInvalidoException,
	ClienteNaoCadastradoException {
		boolean teste = this.ehValido(CPF);
		if (!teste)
			throw new CPFInvalidoException("cpf inválido");
		else {
			Cliente c = this.buscarCliente(CPF);
			if (c != null) {
				return this.clientes.remove(c);
			} else {
				throw new ClienteNaoCadastradoException();
			}
		}
	}

	public List<Cliente> listarClientes() {
		return this.clientes;
	}

	private boolean ehValido(String cpf) {
		// testador de entrada de parâmetros para busca, adição e remoção
		if ((cpf.matches("[0-9]{" + cpf.length() + "}"))
				&& cpf.trim().length() == TAMANHO_DO_CPF)
			return true;
		return false;
	}

}
