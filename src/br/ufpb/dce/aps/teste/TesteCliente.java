package br.ufpb.dce.aps.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.aps.controles.ControleProduto;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;
import br.ufpb.dce.aps.fachada.FachadaFiado;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;
import br.ufpb.dce.aps.fachada.FachadaFiado;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufpb.dce.aps.fachada.FachadaFiado;

public class TesteCliente {

	public FachadaFiado ff ;
	
	@Before
	public void setUp(){
	ff= new FachadaFiado();
	}
	
	@Test
	public void testeCadastraCliente(){
		
	}

}
