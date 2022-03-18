package br.com.lstecnologia.service.profile;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.response.PermissionResponseDTO;
import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.mapper.assembler.PermissionAssembler;
import br.com.lstecnologia.model.ProfileModel;
import br.com.lstecnologia.repository.ProfileRepository;

@Service
public class ProfilePermissionConsultAllService {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private PermissionAssembler permissionAssembler;

	public List<PermissionResponseDTO> consultAllPermission(Long profileId) {

		ProfileModel profileModel = profileRepository.findByIdAndExcludedFalse(profileId)
				.orElseThrow(() -> new ObjectNotFoundException("Profile not found using the given id"));
		
		return profileModel.getPermissions().stream()
				.map(permission -> permissionAssembler.toResponseDTO(permission))
				.collect(Collectors.toList());
	}
	
}
