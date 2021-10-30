package aplicacao;

public class Prova {
	private char[] gabarito;
	private char[] resposta;
	private boolean exist;
	private int pontuacao;
	private String acertadas;
	
	public void Prova() {
		gabarito = new char[10];
		resposta = new char[10];
		exist = false;
		pontuacao = 0;
		acertadas = "";
	}
	
	public char[] getGabarito() {
		return gabarito;
	}
	public void setGabarito (char[] valor) {
		gabarito = valor;
		exist = true;
	}
	
	public char[] getResposta() {
		return resposta;
	}
	public void setResposta (char[] valor) {
		resposta = valor;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public String getAcertadas () {
		return acertadas;
	}
	public void setAcertadas (String acertadas) {
		this.acertadas = acertadas;
	}
	
	
	
	public int gerarPontuacao (char[] resposta, char[] gabarito ) {
		for(int i=0; i<gabarito.length; i++) {
			if(Character.compare(gabarito[i], resposta[i]) == 0) {
				pontuacao++;
				if(pontuacao==1) {
					acertadas = String.valueOf(i+1);
				} else {
					acertadas += ", "+(i+1);
				}
			}
		}
		return pontuacao;
	}
	
	public String imprimirGab() {
		String gabaritoStr = "";
		for(int i=0; i<getGabarito().length; i++) {
			if(i == 0) {
				gabaritoStr += getGabarito()[i];
			} else {
				gabaritoStr += ", "+getGabarito()[i];
			}
		}
		return gabaritoStr;
	}
	
	public String imprimirResp() {
		String respStr = "";
		for(int i=0; i<getResposta().length; i++) {
			if(i == 0) {
				respStr += getResposta()[i];
			} else {
				respStr += ", "+getResposta()[i];
			}
		}
		return respStr;
	}
	
	public boolean existGab() {
		return exist;
	}
}
