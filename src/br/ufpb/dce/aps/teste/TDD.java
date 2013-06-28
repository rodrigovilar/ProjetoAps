package br.ufpb.dce.aps.teste;

import org.junit.Before;

import br.ufpb.dce.aps.fachada.FachadaFiado;

public class TDD {
	public FachadaFiado	f;
	
	@Before
	public void setUp() {
		f = new FachadaFiado();
	}
	/**
	 * {index => listar}
	 * Sequencia de estimulos a serem feitos no sistema
	 * 
	 * projeto.aps.ufpb.br/ => login() 
	 * .../:index => login()
	 * .../:index => login() + Usuario N encontrado
	 * .../:index => login() + Senha errada
	 * .../:index => notificacao()
	 * 
	 * .../venda/ => venda.index()
	 * .../venda/ => venda.index() + N encontrado
	 * .../venda/:index => venda.index()
	 * .../venda/:new => venda.criar_venda()
	 * .../venda/:new => venda.criar_venda() + Nao pode criar
	 * .../venda/:new/:vendedor/:id => venda.get_venda_criada().set_vendedor()
	 * .../venda/:new/:vendedor/:id => venda.get_venda_criada().set_vendedor() + Vendedor n existe 
	 * .../venda/:new/:produto/:id => venda.get_venda_criada().adicionar_item(:produto/:id)
	 * .../venda/:new/:produto/:id => venda.get_venda_criada().adicionar_item(:produto/:id) + Produto n existe
	 * .../venda/:new/:produto/:id => venda.get_venda_criada().adicionar_item(:produto/:id) + Produto n tem no estoque
	 * .../venda/:id => venda.get_by_id(:id)
	 * .../venda/:id => venda.get_by_id(:id) + Venda n existe
	 * .../venda/:id/:edit => venda.get_by_id(:id)
	 * .../venda/:id/:edit => venda.get_by_id(:id) + N pode editar
	 * .../venda/:id/:edit/:produto/:id => venda.get_by_id(:id).adicionar_item(:produto/:id)
	 * .../venda/:id/:edit/:produto/:id => venda.get_by_id(:id).adicionar_item(:produto/:id) + Produto n existe
	 * .../venda/:id/:edit/:produto/:id => venda.get_by_id(:id).adicionar_item(:produto/:id) + Produto n tem no estoque
	 * .../venda/:id/:edit/:produto/:id => venda.get_by_id(:id).editar_quantidade(:produto/:id, :quantidade)
	 * .../venda/:id/:edit/:produto/:id => venda.get_by_id(:id).editar_quantidade(:produto/:id, :quantidade) + quantidade negativa
	 * .../venda/:id/:edit/:produto/:id => venda.get_by_id(:id).editar_quantidade(:produto/:id, :quantidade) + quantida acima do estoque
	 * .../venda/:id/:edit/:produto/:id/:delete => venda.get_by_id(:id).remover_item(:produto/:id)
	 * .../venda/:id/:edit/:produto/:id/:delete => venda.get_by_id(:id).remover_item(:produto/:id) + Produto n esta na venda
	 * .../venda/:id/:edit/:produto/:id/:delete => venda.get_by_id(:id).remover_item(:produto/:id) + lista de venda vazia
	 * .../venda/:id/:delete => venda.delete_by_id(:id)
	 * .../venda/:id/:delete => venda.delete_by_id(:id) + N pode deletar
	 * 
	 * .../produto/ => venda.index()
	 * .../produto/ => venda.index() + N encontrado
	 * .../produto/:index => venda.index()
	 * .../produto/:new => venda.criar_produto()
	 * .../produto/:new => venda.criar_produto() + Nao pode criar
	 * .../produto/:id => venda.get_by_id(:id)
	 * .../produto/:id => venda.get_by_id(:id) + Produto n existe
	 * .../produto/:id/:edit => venda.get_by_id(:id)
	 * .../produto/:id/:edit => venda.get_by_id(:id) + N pode editar
	 * .../produto/:id/:edit/:quantidade => venda.get_by_id(:id).adicionar_estoque(:quantidade)
	 * .../produto/:id/:edit/:quantidade => venda.get_by_id(:id).adicionar_estoque(:quantidade) + quantidade negativa
	 * .../produto/:id/:edit/:quantidade => venda.get_by_id(:id).adicionar_estoque(:quantidade) + numero invalido
	 * .../produto/:id/:delete => venda.delete_by_id(:id)
	 * .../produto/:id/:delete => venda.delete_by_id(:id) + N pode deletar
	 * 
	 * .../conta/ => conta.index()
	 * .../conta/index => conta.index()
	 * .../conta/:new => conta.criar_conta()
	 * .../conta/:new/:cliente_id => conta.get_conta_criada().set_cliente_debito(:cliente_id)
	 * .../conta/:new/:cliente_id => conta.get_conta_criada().set_cliente_debito(:cliente_id) + cliente n existe
	 * .../conta/:id => conta.get_conta_by_id(:id)
	 * .../conta/:id => conta.get_conta_by_id(:id) + conta n existe
	 * .../conta/:id/:edit => conta.get_by_id(:id).alterar_status()
	 * .../conta/:id/:edit => conta.get_by_id(:id).alterar_status() + n pode alterar o status
	 * .../conta/:id/:edit => conta.get_by_id(:id).alterar_data()
	 * .../conta/:id/:edit => conta.get_by_id(:id).alterar_data() + n pode alterar data
	 * .../conta/:id/:edit => conta.get_by_id(:id).alterar_data() + limite excedido
	 * 
	 * .../cliente/ => cliente.index()
	 * .../cliente/:index => cliente.index()
	 * .../cliente/:new => cliente.criar_cliente()
	 * .../cliente/:id => cliente.get_cliente_by_id(:id)
	 * .../cliente/:id/:contas => cliente.get_cliente_by_id(:id).get_contas.index()
	 * .../cliente/:id/:edit => cliente.get_by_id(:id)
	 * .../cliente/:id/:edit/:conta/:id => cliente.get_by_id(:id).get_conta_by_id(:id).alterar_status()
	 * .../cliente/:id/:edit/:conta/:id => cliente.get_by_id(:id).get_conta_by_id(:id).alterar_data()
	 * .../cliente/:id/:delete => cliente.delete_by_id(:id)
	 * */
		
}