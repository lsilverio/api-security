package br.com.lstecnologia.exception;

public abstract class EntidadeNaoEncontradaException extends RegraDeNegocioException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
}
