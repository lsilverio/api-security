package br.com.araujo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.araujo.dto.UsuarioDTO;
import br.com.araujo.exception.ObjectNotFoundException;
import br.com.araujo.model.Usuario;
import br.com.araujo.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioDTO buscarPorId(Long id) {
		
		log.info("Buscando usuario por id: {}", id);
		
		return new UsuarioDTO(usuarioRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Usuario nao encontrado através do id informado")));
	}

	public List<UsuarioDTO> buscarUsuarios() {
		return usuarioRepository.findAll().stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}

	public UsuarioDTO cadastrar(UsuarioDTO usuarioDto) {
		usuarioDto.setId(null);
		return new UsuarioDTO(usuarioRepository.save(new Usuario(usuarioDto)));
	}

}
