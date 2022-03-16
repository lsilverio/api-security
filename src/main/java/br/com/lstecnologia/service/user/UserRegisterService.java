package br.com.lstecnologia.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.request.UserRegisterRequestDTO;
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

	public UserResponseDTO register(UserRegisterRequestDTO userRegisterRequestDTO) {
		UserModel userModel = usuarioDisassembler.toModel(userRegisterRequestDTO);
		
		emailService.validateEquals(userRegisterRequestDTO.getEmail(), userRegisterRequestDTO.getEmailConfirmation());
		passwordService.validateEquals(userRegisterRequestDTO.getPassword(), userRegisterRequestDTO.getPasswordConfirmation());
		
		userModel.setUsername(userRegisterRequestDTO.getEmail());
		userModel.setPassword(passwordService.encode(userModel.getPassword()));
		
		return usuarioAssembler.toResponseDTO(salvar(userModel));
	}

	private UserModel salvar(UserModel userModel) {
		return userRepository.save(userModel);
	}

}
