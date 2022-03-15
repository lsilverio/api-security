package br.com.lstecnologia.service.user;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.request.NewPasswordUserRequestDTO;
import br.com.lstecnologia.dto.request.PasswordUserRequestDTO;
import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.repository.UserRepository;
import br.com.lstecnologia.service.EmailService;
import br.com.lstecnologia.service.PasswordService;
import br.com.lstecnologia.service.UUIDService;

@Service
public class UserPasswordService {
	
	@Autowired
	private UUIDService uUIDService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private PasswordService passwordService;
	
	@Autowired
	private UserRepository userRepository;
	
	public void generateCode(PasswordUserRequestDTO passwordUserRequestDTO) {
		UserModel userModel = getByEmail(passwordUserRequestDTO.getEmail());
		userModel.setUuidPassword(uUIDService.generate());
		userModel.setExpirationDateUuidPassword(LocalDateTime.now().plusMinutes(10));
		emailService.sendUUIDEmail(userModel.getUuidPassword(), passwordUserRequestDTO.getEmail());
		salvar(userModel);
	}

	public void newPassword(NewPasswordUserRequestDTO newPasswordUserRequestDTO) {
		UserModel userModel = getByUuid(newPasswordUserRequestDTO.getUuid());
		uUIDService.isExpired(userModel.getExpirationDateUuidPassword());
		uUIDService.isEquals(newPasswordUserRequestDTO.getUuid(), userModel.getUuidPassword());
		userModel.setPassword(passwordService.encode(newPasswordUserRequestDTO.getPassword()));
		salvar(userModel);
	}
	
	private UserModel getByUuid(String uuid) {
		return userRepository.findByUuidPassword(uuid).orElseThrow(() -> new ObjectNotFoundException("User not found using the given uuid"));
	}
	
	private UserModel getByEmail(String email) {
		return userRepository.findByUsernameAndActiveTrue(email).orElseThrow(() -> new ObjectNotFoundException("User not found using the given email"));
	}
	
	private UserModel salvar(UserModel userModel) {
		return userRepository.save(userModel);
	}

}
