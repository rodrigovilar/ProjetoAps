package br.ufpb.dce.aps.controles;

import java.util.LinkedList;
import java.util.List;

import br.ufpb.dce.aps.DAOs.ClienteDAO;
import br.ufpb.dce.aps.DAOs.DAO;
import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.exception.CPFInvalidoException;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;
import br.ufpb.dce.aps.exception.ClienteNaoCadastradoException;
import br.ufpb.dce.aps.infra.JPAUtil;

public class ControleCliente {

	public static final int TAMANHO_DO_CPF = 11;

	private ClienteDAO dao;
	
	public ControleCliente(){
		this.dao = new ClienteDAO(JPAUtil.getInstance().getEntityManager(),Cliente.class);
	}

	public void cadastrarCliente(Cliente c)
			throws ClienteJaCadastradoException, CPFInvalidoException,
			ClienteNaoCadastradoException {

		// se lista vazia ou cliente não existente
		if (this.buscarCliente(c.getCPF()) == null)
			this.dao.adicionar(c);

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
			for (Cliente p : this.dao.listarTodos())
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
				 this.dao.remover(c);
				 return true;
			} else {
				throw new ClienteNaoCadastradoException();
			}
		}
	}

	public List<Cliente> listarClientes() {
		return this.dao.listarTodos();
	}

	private boolean ehValido(String cpf) {
		// testador de entrada de parâmetros para busca, adição e remoção
		if ((cpf.matches("[0-9]{" + cpf.length() + "}"))
				&& cpf.trim().length() == TAMANHO_DO_CPF)
			return true;
		return false;
	}

}
