package br.com.lstecnologia.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.request.UserRequestDTO;
import br.com.lstecnologia.dto.response.UserResponseDTO;
import br.com.lstecnologia.mapper.assembler.UserAssembler;
import br.com.lstecnologia.mapper.disassembler.UserDisassembler;
import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.repository.UserRepository;
import br.com.lstecnologia.service.EmailService;
import br.com.lstecnologia.service.PasswordService;

@Service
public class UserRegisterService {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserAssembler usuarioAssembler;
	
	@Autowired
	private PasswordService passwordService;
	
	@Autowired
	private UserDisassembler usuarioDisassembler;

	public UserResponseDTO register(UserRequestDTO userRequestDto) {
		UserModel userModel = usuarioDisassembler.toModel(userRequestDto);
		emailService.validateEquals(userRequestDto.getEmail(), userRequestDto.getEmailConfirmation());
		userModel.setUsername(userRequestDto.getEmail());
		userModel.setPassword(passwordService.encode(userModel.getPassword()));
		userModel = userRepository.save(userModel);
		return usuarioAssembler.toResponseDTO(userModel);
	}

}
