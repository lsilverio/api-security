package br.com.lstecnologia.service.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.model.PermissionModel;
import br.com.lstecnologia.model.ProfileModel;
import br.com.lstecnologia.repository.PermissionRepository;
import br.com.lstecnologia.repository.ProfileRepository;

@Service
public class ProfilePermissionRemoveService {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;

	public void removePermission(Long profileId, Long permissionId) {

		ProfileModel profileModel = profileRepository.findByIdAndExcludedFalse(profileId)
				.orElseThrow(() -> new ObjectNotFoundException("Profile not found using the given id"));
		
		PermissionModel permissionModel = permissionRepository.findByIdAndExcludedFalse(permissionId)
				.orElseThrow(() -> new ObjectNotFoundException("Permission not found using the given id"));
		
		profileModel.getPermissions().remove(permissionModel);
		profileRepository.save(profileModel);
	}

}
