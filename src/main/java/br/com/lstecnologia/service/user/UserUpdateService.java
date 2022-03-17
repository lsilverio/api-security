package br.com.lstecnologia.service.user;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.request.user.UserUpdateRequestDTO;
import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.exception.RegraDeNegocioException;
import br.com.lstecnologia.mapper.disassembler.UserDisassembler;
import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.repository.UserRepository;
import br.com.lstecnologia.security.CheckSecurity;
import br.com.lstecnologia.service.EmailService;

@Service
public class UserUpdateService {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private CheckSecurity checkSecurity;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDisassembler userDisassembler;

	public void update(Long id, UserUpdateRequestDTO userUpdateRequestDTO) {
		UserModel userModel = getById(id);
		checkInactivation(userModel.isActive(), userUpdateRequestDTO.isActive(), userUpdateRequestDTO.getJustificationInactivation());
		userDisassembler.copyRequestDtoToModel(userUpdateRequestDTO, userModel);
		emailService.validateEquals(userUpdateRequestDTO.getEmail(), userUpdateRequestDTO.getEmailConfirmation());
		userModel.setUsername(userUpdateRequestDTO.getEmail());
		userModel.setUserId(checkSecurity.getUserId());
		userRepository.save(userModel);
	}
	
	private void checkInactivation(boolean activeUserModel, boolean activeUserRequestDto, String justificationInactivation) {
		if(activeUserModel && (!activeUserRequestDto && ObjectUtils.isEmpty(justificationInactivation))) {
			throw new RegraDeNegocioException("User inactivation justification is mandatory");
		}
	}

	private UserModel getById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found using the given id"));
	}

}
