package br.com.lstecnologia.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.request.UserRequestDto;
import br.com.lstecnologia.dto.response.UserResponseDto;
import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.mapper.assembler.UserAssembler;
import br.com.lstecnologia.mapper.disassembler.UserDisassembler;
import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserAssembler usuarioAssembler;
	
	@Autowired
	private UserDisassembler usuarioDisassembler;
	
	@Autowired
	private UserRepository usuarioRepository;
	
	public UserResponseDto buscarPorId(Long id) {
		UserModel userModel = usuarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found using the given id"));
		return toResponseDTO(userModel);
	}

	public List<UserResponseDto> buscarUsuarios() {
		return usuarioRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
	}

	public UserResponseDto cadastrar(UserRequestDto userRequestDto) {
		UserModel userModel = usuarioDisassembler.toModel(userRequestDto);
		return toResponseDTO(userModel);
	}
	
	private UserResponseDto toResponseDTO(UserModel userModel) {
		return usuarioAssembler.toResponseDTO(userModel);
	}

}
