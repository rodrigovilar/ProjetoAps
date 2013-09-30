package br.ufpb.dce.aps.controles;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import br.ufpb.dce.aps.dao.CobrancaDao;
import br.ufpb.dce.aps.entidades.Cobranca;
import br.ufpb.dce.aps.exception.ValorInvalidoException;
import br.ufpb.dce.aps.exception.VendaException;
import br.ufpb.dce.aps.infra.JPAUtil;

public class ControleCobranca {
	private CobrancaDao dao;

	public ControleCobranca() {
		this.dao = new CobrancaDao(JPAUtil.getInstance().getEntityManager(),
				Cobranca.class);
	}

	// n�o posso ter uma outra cobran�a com um mesmo id de venda
	public void addCobranca(Cobranca cobranca, String idVenda)
			throws VendaException {

		Cobranca cob = dao.procurar(cobranca.getId());
		if (cob == null)
			dao.adicionar(cobranca);
		else
			throw new VendaException("venda exception na cobran�a");
	}

	// A vista
	public void pagarCobranca(String idCobranca) {
		Cobranca cobranca = dao.procurar(idCobranca);
		cobranca.setPagamentoEfetuado(true);
		cobranca.getVenda().setDataPagamento(new Date());
		dao.atualizar(cobranca);
	}

	public Cobranca exibirCobranca(String idVenda) {
		return this.dao.procurar(idVenda);
	}

	public List<Cobranca> listarTodasAsCobrancas() {
		return this.dao.listarTodos();
	}

	// puxar dados do cliente para o controle de vendas
	public List<Cobranca> listarDebitosDeCliente(String CPF)
			throws ValorInvalidoException {
		
		System.out.println("//////////////////////////");
		System.out.println(CPF.trim().matches("[0-9]{11}") && CPF.length() == 11);
		System.out.println("//////////////////////////");

		if (CPF.trim().matches("[0-9]{11}") && CPF.length() == 11) {
			List<Cobranca> lista = new LinkedList<Cobranca>();
			for (Cobranca c : this.dao.listarTodos())
				if (c.getVenda().getCliente().getCPF() == CPF)
					lista.add(c);
			return lista;
		}

		System.out.println("//////////////////////////");
		System.out.println(CPF.trim().matches("[0-9]{11}") && CPF.length() == 11);
		System.out.println("//////////////////////////");
		throw new ValorInvalidoException("CPF inv�lido");
	}
}