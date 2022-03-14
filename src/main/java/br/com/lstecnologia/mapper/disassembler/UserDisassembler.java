package br.com.lstecnologia.mapper.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lstecnologia.dto.request.UserRequestDto;
import br.com.lstecnologia.model.UserModel;

@Component
public class UserDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UserModel toModel(UserRequestDto apresentacaoDtoResponse) {
		return modelMapper.map(apresentacaoDtoResponse, UserModel.class);
	}
	
	public void copyRequestDtoToModel(UserRequestDto userRequestDTO, UserModel userModel) {
		modelMapper.map(userRequestDTO, userModel);
	}

}
