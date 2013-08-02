package br.ufpb.dce.aps.teste;

import org.junit.Before;
import static org.junit.Assert.assertEquals;
import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;

import br.ufpb.dce.aps.entidades.Venda;
import br.ufpb.dce.aps.fachada.FachadaFiado;

public class TesteVenda {

	private FachadaFiado ff;
	private Venda venda;
	
	@Before
	public void setUp(){
		
		this.ff = new FachadaFiado();
		this.venda = new Venda();
		
		ff.vender(this.venda);
	}

	public void checkVendaRealizada(){
		assertEquals(true , ff.buscarVenda(venda.getIdVenda()));
	}

}
