package br.com.lstecnologia.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.lstecnologia.exception.RegraDeNegocioException;

@Service
public class PasswordService {
	
	public String encode(String password) {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		return bCrypt.encode(password);
	}
	
	public void validateEquals(String password, String confirmationPassword) {
		
		if(ObjectUtils.isEmpty(password) || ObjectUtils.isEmpty(confirmationPassword)) {
			throw new RegraDeNegocioException("The password and confirmation password is required");
		}
		
		if(!password.equals(confirmationPassword)) {
			throw new RegraDeNegocioException("The password and confirmation password must match");
		}
	}

}
