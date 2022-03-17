package br.com.lstecnologia.mapper.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lstecnologia.dto.request.user.UserRegisterRequestDTO;
import br.com.lstecnologia.dto.request.user.UserUpdateRequestDTO;
import br.com.lstecnologia.model.UserModel;

@Component
public class UserDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UserModel toModel(UserRegisterRequestDTO userRegisterRequestDTO) {
		return modelMapper.map(userRegisterRequestDTO, UserModel.class);
	}
	
	public void copyRequestDtoToModel(UserUpdateRequestDTO userUpdateRequestDTO, UserModel userModel) {
		modelMapper.map(userUpdateRequestDTO, userModel);
	}

}
