package br.com.lstecnologia.service.user;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.request.user.UserEmailRequestDTO;
import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.repository.UserRepository;
import br.com.lstecnologia.service.EmailService;
import br.com.lstecnologia.service.UUIDService;

@Service
public class UserUuidPasswordService {
	
	@Autowired
	private UUIDService uUIDService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserRepository userRepository;
	
	public void generateCode(UserEmailRequestDTO userEmailRequestDTO) {
		UserModel userModel = getByEmail(userEmailRequestDTO.getEmail());
		userModel.setUuidPassword(uUIDService.generate());
		userModel.setExpirationDateUuidPassword(LocalDateTime.now().plusMinutes(10));
		emailService.sendUUIDEmail(userModel.getUuidPassword(), userEmailRequestDTO.getEmail());
		salvar(userModel);
	}
	
	private UserModel getByEmail(String email) {
		return userRepository.findByUsernameAndActiveTrue(email).orElseThrow(() -> new ObjectNotFoundException("User not found using the given email"));
	}
	
	private UserModel salvar(UserModel userModel) {
		return userRepository.save(userModel);
	}

}
