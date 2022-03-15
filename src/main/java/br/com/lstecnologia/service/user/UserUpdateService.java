package br.com.lstecnologia.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.request.UserRequestDTO;
import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.mapper.disassembler.UserDisassembler;
import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.repository.UserRepository;
import br.com.lstecnologia.service.EmailService;

@Service
public class UserUpdateService {
	
	@Autowired
	private UserDisassembler usuarioDisassembler;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmailService emailService;

	public void update(Long id, UserRequestDTO userRequestDto) {
		UserModel userModel = getById(id);
		usuarioDisassembler.copyRequestDtoToModel(userRequestDto, userModel);
		emailService.validateEquals(userRequestDto.getEmail(), userRequestDto.getEmailConfirmation());
		userModel.setUsername(userRequestDto.getEmail());
		userRepository.save(userModel);
	}
	
	private UserModel getById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found using the given id"));
	}

}
