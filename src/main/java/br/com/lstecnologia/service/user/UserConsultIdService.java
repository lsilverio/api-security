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
import br.com.lstecnologia.security.permission.UserPermissonSecurity;

@Service
public class UserConsultIdService {
	
	@Autowired
	private CheckSecurity checkSecurity;
	
	@Autowired
	private UserAssembler usuarioAssembler;
	
	@Autowired
	private UserRepository userRepository;
	
	public UserResponseDTO getById(Long id) {

		if(!checkSecurity.isEqualsUserId(id) && !checkSecurity.hasAuthority(UserPermissonSecurity.CONSULT_ALL_BY_ID_USERS.getDescription())) {
			throw new RegraDeNegocioException("The user id entered does not belong to the logged in user");
		}
		
		UserModel userModel = userRepository.findByIdAndExcludedFalse(id)
				.orElseThrow(() -> new ObjectNotFoundException("User not found using the given id"));
		
		return usuarioAssembler.toResponseDTO(userModel);
	}

}
