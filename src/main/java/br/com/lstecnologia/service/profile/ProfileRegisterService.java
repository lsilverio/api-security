package br.com.lstecnologia.service.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.request.profile.ProfileRegisterRequestDTO;
import br.com.lstecnologia.dto.response.ProfileResponseDTO;
import br.com.lstecnologia.mapper.assembler.ProfileAssembler;
import br.com.lstecnologia.mapper.disassembler.ProfileDisassembler;
import br.com.lstecnologia.model.ProfileModel;
import br.com.lstecnologia.repository.ProfileRepository;
import br.com.lstecnologia.security.CheckSecurity;

@Service
public class ProfileRegisterService {
	
	@Autowired
	private CheckSecurity checkSecurity;
	
	@Autowired
	private ProfileAssembler profileAssembler;

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private ProfileDisassembler profileDisassembler;

	public ProfileResponseDTO register(ProfileRegisterRequestDTO profileRegisterRequestDTO) {
		ProfileModel profileModel = profileDisassembler.toModel(profileRegisterRequestDTO);
		profileModel.setName(profileRegisterRequestDTO.getName());
		profileModel.setUserId(checkSecurity.getUserId());
		return profileAssembler.toResponseDTO(salvar(profileModel));
	}

	private ProfileModel salvar(ProfileModel profileModel) {
		return profileRepository.save(profileModel);
	}

}
