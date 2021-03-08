package br.com.araujo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.araujo.dto.UsuarioDTO;
import br.com.araujo.security.CheckSecurity;
import br.com.araujo.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(tags = "Usuario")
@RestController
@RequestMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@CheckSecurity.Usuarios.PodeConsultar
	@GetMapping
	@ApiOperation(value = "Buscar usuários", response = UsuarioDTO[].class)
	public ResponseEntity<Object> buscarUsuarios() {
		log.info("Buscar usuarios");
		return ResponseEntity.ok().body(usuarioService.buscarUsuarios());
	}
	
	@CheckSecurity.Usuarios.PodeConsultar
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Buscar usuário por id", response = UsuarioDTO.class)
	public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
		log.info("Buscar usuario por id: " + id);
		return ResponseEntity.ok().body(usuarioService.buscarPorId(id));
	}
	
	@CheckSecurity.Usuarios.PodeEditar
	@PostMapping
	@ApiOperation(value = "Cadastrar usuário", response = UsuarioDTO.class)
	public ResponseEntity<Object> cadastrar(@RequestBody UsuarioDTO usuarioDto) {
		usuarioDto = usuarioService.cadastrar(usuarioDto);
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuarioDto.getId()).toUri()).body(usuarioDto);
	}

}
