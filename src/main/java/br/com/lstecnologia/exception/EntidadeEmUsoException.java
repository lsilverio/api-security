package br.com.lstecnologia.exception;

public class EntidadeEmUsoException extends RegraDeNegocioException {

	private static final long serialVersionUID = 1L;

	public EntidadeEmUsoException(String mensagem) {
		super(mensagem);
	}
	
}
