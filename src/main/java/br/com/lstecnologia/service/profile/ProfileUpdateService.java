package br.com.lstecnologia.service.profile;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.request.profile.ProfileUpdateRequestDTO;
import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.exception.RegraDeNegocioException;
import br.com.lstecnologia.mapper.disassembler.ProfileDisassembler;
import br.com.lstecnologia.model.ProfileModel;
import br.com.lstecnologia.repository.ProfileRepository;
import br.com.lstecnologia.security.CheckSecurity;

@Service
public class ProfileUpdateService {
	
	@Autowired
	private CheckSecurity checkSecurity;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private ProfileDisassembler profileDisassembler;

	public void update(Long id, ProfileUpdateRequestDTO profileUpdateRequestDTO) {
		ProfileModel profileModel = getById(id);
		checkInactivation(profileModel.isActive(), profileUpdateRequestDTO.isActive(), profileUpdateRequestDTO.getJustificationInactivation());
		profileDisassembler.copyRequestDtoToModel(profileUpdateRequestDTO, profileModel);
		profileModel.setName(profileUpdateRequestDTO.getName());
		profileModel.setUserId(checkSecurity.getUserId());
		profileRepository.save(profileModel);
	}
	
	private void checkInactivation(boolean activeProfileModel, boolean activeProfileRequestDto, String justificationInactivation) {
		if(activeProfileModel && (!activeProfileRequestDto && ObjectUtils.isEmpty(justificationInactivation))) {
			throw new RegraDeNegocioException("Profile inactivation justification is mandatory");
		}
	}

	private ProfileModel getById(Long id) {
		return profileRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Profile not found using the given id"));
	}

}
