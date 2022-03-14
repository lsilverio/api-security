package br.com.lstecnologia.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.request.UserRequestDto;
import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.mapper.disassembler.UserDisassembler;
import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.repository.UserRepository;

@Service
public class UserUpdateService {
	
	@Autowired
	private UserDisassembler usuarioDisassembler;
	
	@Autowired
	private UserRepository userRepository;

	public void update(Long id, UserRequestDto userRequestDto) {
		UserModel userModel = getById(id);
		usuarioDisassembler.copyRequestDtoToModel(userRequestDto, userModel);
		userRepository.save(userModel);
	}
	
	public UserModel getById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found using the given id"));
	}

}
