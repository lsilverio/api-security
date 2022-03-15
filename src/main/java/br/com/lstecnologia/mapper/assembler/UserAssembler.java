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
	public UserResponseDTO toModel(UserModel usuarioModel) {

		UserResponseDTO usuarioResponseDto = modelMapper.map(usuarioModel, UserResponseDTO.class);

		usuarioResponseDto
				.add(linkTo(methodOn(UserConsultAllController.class).getAll()).withRel("usuarios"));

		usuarioResponseDto
				.add(linkTo(methodOn(UserConsultIdController.class).getById(usuarioResponseDto.getId()))
						.withSelfRel());

		return usuarioResponseDto;
	}

	public UserResponseDTO toResponseDTO(UserModel usuarioModel) {
		return toModel(usuarioModel);
	}

}
