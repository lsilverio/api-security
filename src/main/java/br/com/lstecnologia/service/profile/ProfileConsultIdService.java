package br.com.lstecnologia.service.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.response.ProfileResponseDTO;
import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.mapper.assembler.ProfileAssembler;
import br.com.lstecnologia.model.ProfileModel;
import br.com.lstecnologia.repository.ProfileRepository;

@Service
public class ProfileConsultIdService {
	
	@Autowired
	private ProfileAssembler profileAssembler;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public ProfileResponseDTO getById(Long id) {
		
		ProfileModel profileModel = profileRepository.findByIdAndExcludedFalse(id)
				.orElseThrow(() -> new ObjectNotFoundException("Profile not found using the given id"));
		
		return profileAssembler.toResponseDTO(profileModel);
	}

}
