package br.ufpb.dce.aps.entidades;
public class Notificacao {

	private boolean ativa;

	private String formuarioNotificacao;

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public String getFormuarioNotificacao() {
		return formuarioNotificacao;
	}

	public void setFormuarioNotificacao(String formuarioNotificacao) {
		this.formuarioNotificacao = formuarioNotificacao;
	}

}
