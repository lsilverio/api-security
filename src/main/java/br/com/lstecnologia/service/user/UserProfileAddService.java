package br.com.lstecnologia.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.model.ProfileModel;
import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.repository.ProfileRepository;
import br.com.lstecnologia.repository.UserRepository;

@Service
public class UserProfileAddService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProfileRepository profileRepository;

	public void addProfile(Long userId, Long profileId) {

		UserModel userModel = userRepository.findByIdAndExcludedFalse(userId)
				.orElseThrow(() -> new ObjectNotFoundException("User not found using the given id"));
		
		ProfileModel profileModel = profileRepository.findByIdAndExcludedFalse(profileId)
				.orElseThrow(() -> new ObjectNotFoundException("Profile not found using the given id"));
		
		userModel.getProfiles().add(profileModel);
		userRepository.save(userModel);
	}

}
