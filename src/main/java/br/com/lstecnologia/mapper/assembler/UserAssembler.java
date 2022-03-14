package br.com.lstecnologia.mapper.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.lstecnologia.controller.user.UserConsultController;
import br.com.lstecnologia.dto.response.UserResponseDto;
import br.com.lstecnologia.model.UserModel;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserModel, UserResponseDto> {

	@Autowired
	private ModelMapper modelMapper;

	public UserAssembler() {
		super(UserConsultController.class, UserResponseDto.class);
	}

	@Override
	public UserResponseDto toModel(UserModel usuarioModel) {

		UserResponseDto usuarioResponseDto = modelMapper.map(usuarioModel, UserResponseDto.class);

		usuarioResponseDto
				.add(linkTo(methodOn(UserConsultController.class).getAll()).withRel("usuarios"));

		usuarioResponseDto
				.add(linkTo(methodOn(UserConsultController.class).getById(usuarioResponseDto.getId()))
						.withSelfRel());

		return usuarioResponseDto;
	}

	public UserResponseDto toResponseDTO(UserModel usuarioModel) {
		return toModel(usuarioModel);
	}

}
