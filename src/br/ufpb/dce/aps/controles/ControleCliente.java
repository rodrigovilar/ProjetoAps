package br.ufpb.dce.aps.controles;

import java.util.List;

import br.ufpb.dce.aps.dao.ClienteDao;
import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.exception.CPFInvalidoException;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;
import br.ufpb.dce.aps.exception.ClienteNaoCadastradoException;
import br.ufpb.dce.aps.infra.JPAUtil;

public class ControleCliente {

	public static final int TAMANHO_DO_CPF = 11;
	private ClienteDao dao;

	public ControleCliente() {
		dao = new ClienteDao(JPAUtil.getInstance().getEntityManager(),
				Cliente.class);
	}

	public void cadastrarCliente(Cliente c)
			throws ClienteJaCadastradoException, CPFInvalidoException,
			ClienteNaoCadastradoException {

		// se lista vazia ou cliente n�o existente
		// Carregamento Lazy
		Cliente cl = this.buscarCliente(c.getCPF());
		if (cl == null)
			this.dao.adicionar(c);
		else
			throw new ClienteJaCadastradoException("Cliente exception");
	}

	public Cliente buscarCliente(String cpf) throws CPFInvalidoException,
			ClienteNaoCadastradoException {
		boolean teste = this.ehValido(cpf);
		if (!teste)
			throw new CPFInvalidoException("CPF inv�lido");

		return this.dao.procurar(cpf);
	}

	public boolean removerCliente(String CPF) throws CPFInvalidoException,
			ClienteNaoCadastradoException {
		boolean teste = this.ehValido(CPF);
		if (!teste)
			throw new CPFInvalidoException("cpf inv�lido");

		Cliente c = this.buscarCliente(CPF);
		if (c != null) {
			this.dao.remover(c);
			return true;
		}

		throw new ClienteNaoCadastradoException();
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