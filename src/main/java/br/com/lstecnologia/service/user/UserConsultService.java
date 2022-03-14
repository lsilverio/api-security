package br.com.lstecnologia.service.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.response.UserResponseDto;
import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.mapper.assembler.UserAssembler;
import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.repository.UserRepository;

@Service
public class UserConsultService {
	
	@Autowired
	private UserAssembler usuarioAssembler;
	
	@Autowired
	private UserRepository userRepository;
	
	public UserResponseDto getById(Long id) {
		UserModel userModel = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found using the given id"));
		return toResponseDTO(userModel);
	}

	public List<UserResponseDto> getAll() {
		return userRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
	}

	private UserResponseDto toResponseDTO(UserModel userModel) {
		return usuarioAssembler.toResponseDTO(userModel);
	}

}
