package br.com.lstecnologia.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.lstecnologia.exception.RegraDeNegocioException;

@Service
public class EmailService {
	
	public void validateEquals(String email, String confirmationEmail) {
		
		if(ObjectUtils.isEmpty(email) || ObjectUtils.isEmpty(confirmationEmail)) {
			throw new RegraDeNegocioException("The email and confirmation email is required");
		}
		
		if(!email.equals(confirmationEmail)) {
			throw new RegraDeNegocioException("The email and confirmation email must match");
		}
	}

	public void sendUUIDEmail(String uuid, String email) {
		
	}

}
