package br.com.lstecnologia.mapper.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lstecnologia.dto.request.profile.ProfileRegisterRequestDTO;
import br.com.lstecnologia.dto.request.profile.ProfileUpdateRequestDTO;
import br.com.lstecnologia.model.ProfileModel;

@Component
public class ProfileDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ProfileModel toModel(ProfileRegisterRequestDTO profileRegisterRequestDTO) {
		return modelMapper.map(profileRegisterRequestDTO, ProfileModel.class);
	}
	
	public void copyRequestDtoToModel(ProfileUpdateRequestDTO profileUpdateRequestDTO, ProfileModel profileModel) {
		modelMapper.map(profileUpdateRequestDTO, profileModel);
	}

}
