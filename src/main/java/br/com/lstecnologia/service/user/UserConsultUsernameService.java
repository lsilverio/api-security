package br.com.lstecnologia.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.repository.UserRepository;

@Service
public class UserConsultUsernameService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserModel findByUsername(String username) {
		return userRepository.findByUsernameAndActiveTrue(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username provided"));
	}

}
