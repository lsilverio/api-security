package br.com.lstecnologia.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.lstecnologia.exception.RegraDeNegocioException;

@Service
public class UUIDService {
	
	public String generate() {
		return UUID.randomUUID().toString();
	}

	public void validateExpired(LocalDateTime expirationDate) {
		LocalDateTime agora = LocalDateTime.now();
		if(agora.isAfter(expirationDate)) {
			throw new RegraDeNegocioException("The UUID expired ");
		}
	}

	public void validateEquals(String uuidOne, String uuidTwo) {
		if(!uuidOne.equals(uuidTwo)) {
			throw new RegraDeNegocioException("The UUID provided is invalid");
		}
	}

}
