package br.com.lstecnologia.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.repository.UserRepository;

@Service
public class UserDeleteService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

}
