package br.com.lstecnologia.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.response.UserResponseDTO;
import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.exception.RegraDeNegocioException;
import br.com.lstecnologia.mapper.assembler.UserAssembler;
import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.repository.UserRepository;
import br.com.lstecnologia.security.CheckSecurity;
import br.com.lstecnologia.security.permission.user.UserPermissonSecurity;

@Service
public class UserConsultIdService {
	
	private static final String PODE_CONSULTAR_QUALQUER_USUARIO = UserPermissonSecurity.USER_CONSULT_ALL_BY_ID.getDescription();

	@Autowired
	private CheckSecurity checkSecurity;
	
	@Autowired
	private UserAssembler userAssembler;
	
	@Autowired
	private UserRepository userRepository;
	
	public UserResponseDTO getById(Long id) {

		if(!checkSecurity.isEqualsUserId(id) && !checkSecurity.hasAuthority(PODE_CONSULTAR_QUALQUER_USUARIO)) {
			throw new RegraDeNegocioException("The user id entered does not belong to the logged in user");
		}
		
		UserModel userModel = userRepository.findByIdAndExcludedFalse(id)
				.orElseThrow(() -> new ObjectNotFoundException("User not found using the given id"));
		
		return userAssembler.toResponseDTO(userModel);
	}

}
