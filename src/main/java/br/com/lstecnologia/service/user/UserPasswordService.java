package br.com.lstecnologia.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.request.user.UserNewPasswordRequestDTO;
import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.repository.UserRepository;
import br.com.lstecnologia.service.PasswordService;
import br.com.lstecnologia.service.UUIDService;

@Service
public class UserPasswordService {
	
	@Autowired
	private UUIDService uUIDService;
	
	@Autowired
	private PasswordService passwordService;
	
	@Autowired
	private UserRepository userRepository;
	
	public void newPassword(UserNewPasswordRequestDTO userNewPasswordRequestDTO) {
		UserModel userModel = getByUuid(userNewPasswordRequestDTO.getUuid());
		uUIDService.validateExpired(userModel.getExpirationDateUuidPassword());
		uUIDService.validateEquals(userNewPasswordRequestDTO.getUuid(), userModel.getUuidPassword());
		passwordService.validateEquals(userNewPasswordRequestDTO.getPassword(), userNewPasswordRequestDTO.getPasswordConfirmation());
		userModel.setPassword(passwordService.encode(userNewPasswordRequestDTO.getPassword()));
		salvar(userModel);
	}
	
	private UserModel getByUuid(String uuid) {
		return userRepository.findByUuidPassword(uuid).orElseThrow(() -> new ObjectNotFoundException("User not found using the given uuid"));
	}
	
	private UserModel salvar(UserModel userModel) {
		return userRepository.save(userModel);
	}

}
