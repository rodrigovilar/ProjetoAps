package br.ufpb.dce.aps;

import java.util.Date;

import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.entidades.Endereco;
import br.ufpb.dce.aps.entidades.Item;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.entidades.Venda;
import br.ufpb.dce.aps.exception.CPFInvalidoException;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;
import br.ufpb.dce.aps.exception.ClienteNaoCadastradoException;
import br.ufpb.dce.aps.fachada.FachadaFiado;

public class Adiciona {
	public static void main(String[] args) throws CPFInvalidoException,
			ClienteJaCadastradoException, ClienteNaoCadastradoException {
		FachadaFiado ff = new FachadaFiado();
		Cliente cliente;
		Endereco endereco;
		Produto produto;
		Venda venda;
		Item item;

		endereco = new Endereco("12", "Rua", "Bairro", "referencia");

		cliente = new Cliente();
		cliente.setCPF("12345678901");
		cliente.setNome("duza");
		cliente.setTelefone("098909879");
		cliente.setEndereco(endereco);

		produto = new Produto();
		produto.setCodigo("1");
		produto.setNome("NAL");
		produto.setPreco(100);

		venda = new Venda();

		item = new Item();
		item.setProduto(produto);
		item.setQuantidade(20);

		venda.setIdVenda("1");
		venda.setValor(400);
		venda.getItems().add(item);
		venda.setCliente(cliente);
		venda.setDataVenda(new Date());
		venda.setDataPagamento(new Date());

		ff.cadastrarCliente(cliente);
		ff.cadastrarProduto(produto);
		ff.vender(venda);
		
		System.out.println(ff.listarVendasRalizadas().size());
	}
}