package br.com.araujo.dto;

import br.com.araujo.model.Usuario;
import lombok.Data;

@Data
public class UsuarioDTO {

	private Long id;
	private String nome;
	private String username;
	private String password;
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.username = usuario.getUsername();
	}
	
}
