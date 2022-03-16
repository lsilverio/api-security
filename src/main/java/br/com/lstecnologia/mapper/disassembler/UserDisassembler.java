package br.com.lstecnologia.mapper.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lstecnologia.dto.request.UserRegisterRequestDTO;
import br.com.lstecnologia.dto.request.UserRequestDTO;
import br.com.lstecnologia.model.UserModel;

@Component
public class UserDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UserModel toModel(UserRequestDTO userRequestDTO) {
		return modelMapper.map(userRequestDTO, UserModel.class);
	}
	
	public UserModel toModel(UserRegisterRequestDTO userRegisterRequestDTO) {
		return modelMapper.map(userRegisterRequestDTO, UserModel.class);
	}
	
	public void copyRequestDtoToModel(UserRequestDTO userRequestDTO, UserModel userModel) {
		modelMapper.map(userRequestDTO, userModel);
	}

}
