package br.com.lstecnologia.controller;

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

import br.com.lstecnologia.dto.request.UserRequestDto;
import br.com.lstecnologia.dto.response.UserResponseDto;
import br.com.lstecnologia.security.UserSecurity;
import br.com.lstecnologia.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "User")
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	private UserService usuarioService;
	
	@UserSecurity.Permission.Consult
	@GetMapping
	@ApiOperation(value = "Get all users", response = UserResponseDto[].class)
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok().body(usuarioService.buscarUsuarios());
	}
	
	@UserSecurity.Permission.Consult
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Buscar usuário por id", response = UserResponseDto.class)
	public ResponseEntity<Object> getById(@PathVariable Long id) {
		return ResponseEntity.ok().body(usuarioService.buscarPorId(id));
	}
	
	@UserSecurity.Permission.Register
	@PostMapping
	@ApiOperation(value = "Register new user", response = UserResponseDto.class)
	public ResponseEntity<Object> register(@RequestBody UserRequestDto usuarioDto) {
		
		UserResponseDto usuarioResponseDto = usuarioService.cadastrar(usuarioDto);
		
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuarioResponseDto.getId()).toUri()).body(usuarioResponseDto);
	}

}
