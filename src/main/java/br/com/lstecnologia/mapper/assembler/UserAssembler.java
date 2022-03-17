package br.com.lstecnologia.mapper.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.lstecnologia.controller.user.UserConsultAllController;
import br.com.lstecnologia.controller.user.UserConsultIdController;
import br.com.lstecnologia.dto.response.UserResponseDTO;
import br.com.lstecnologia.model.UserModel;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserModel, UserResponseDTO> {

	@Autowired
	private ModelMapper modelMapper;

	public UserAssembler() {
		super(UserConsultAllController.class, UserResponseDTO.class);
	}

	@Override
	public UserResponseDTO toModel(UserModel userModel) {

		UserResponseDTO userResponseDTO = modelMapper.map(userModel, UserResponseDTO.class);

		userResponseDTO
				.add(linkTo(methodOn(UserConsultAllController.class)
						.getAll(0, userModel.getUsername(), userModel.getName())).withRel("users"));

		userResponseDTO
				.add(linkTo(methodOn(UserConsultIdController.class).getById(userResponseDTO.getId()))
						.withSelfRel());

		return userResponseDTO;
	}

	public UserResponseDTO toResponseDTO(UserModel userModel) {
		return toModel(userModel);
	}

}
