package br.com.lstecnologia.service.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.response.UserResponseDTO;
import br.com.lstecnologia.mapper.assembler.UserAssembler;
import br.com.lstecnologia.repository.UserRepository;

@Service
public class UserConsultAllService {
	
	@Autowired
	private UserAssembler usuarioAssembler;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserResponseDTO> getAll() {
		return userRepository.findAll().stream().map(user -> usuarioAssembler.toResponseDTO(user)).collect(Collectors.toList());
	}

}
