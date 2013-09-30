package br.ufpb.dce.aps;

import br.ufpb.dce.aps.exception.CPFInvalidoException;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;
import br.ufpb.dce.aps.exception.ClienteNaoCadastradoException;
import br.ufpb.dce.aps.fachada.FachadaFiado;

public class Adiciona {
	public static void main(String[] args) throws CPFInvalidoException,
			ClienteJaCadastradoException, ClienteNaoCadastradoException {
		FachadaFiado ff = new FachadaFiado();
	}
}