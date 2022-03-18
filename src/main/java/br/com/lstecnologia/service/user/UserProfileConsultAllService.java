package br.com.lstecnologia.service.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.response.ProfileResponseDTO;
import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.mapper.assembler.ProfileAssembler;
import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.repository.UserRepository;

@Service
public class UserProfileConsultAllService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProfileAssembler profileAssembler;

	public List<ProfileResponseDTO> consultAllProfile(Long userId) {

		UserModel userModel = userRepository.findByIdAndExcludedFalse(userId)
				.orElseThrow(() -> new ObjectNotFoundException("User not found using the given id"));
		
		return userModel.getProfiles().stream()
				.map(profile -> profileAssembler.toResponseDTO(profile))
				.collect(Collectors.toList());
	}
	
}
