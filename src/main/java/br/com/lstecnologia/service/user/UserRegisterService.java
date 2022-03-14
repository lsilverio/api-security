package br.com.lstecnologia.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.request.UserRequestDto;
import br.com.lstecnologia.dto.response.UserResponseDto;
import br.com.lstecnologia.mapper.assembler.UserAssembler;
import br.com.lstecnologia.mapper.disassembler.UserDisassembler;
import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.repository.UserRepository;

@Service
public class UserRegisterService {
	
	@Autowired
	private UserAssembler usuarioAssembler;
	
	@Autowired
	private UserDisassembler usuarioDisassembler;
	
	@Autowired
	private UserRepository userRepository;

	public UserResponseDto register(UserRequestDto userRequestDto) {
		UserModel userModel = usuarioDisassembler.toModel(userRequestDto);
		userModel = userRepository.save(userModel);
		return toResponseDTO(userModel);
	}
	
	private UserResponseDto toResponseDTO(UserModel userModel) {
		return usuarioAssembler.toResponseDTO(userModel);
	}

}
