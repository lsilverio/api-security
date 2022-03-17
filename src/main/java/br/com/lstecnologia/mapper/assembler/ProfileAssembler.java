package br.com.lstecnologia.mapper.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.lstecnologia.controller.profile.ProfileConsultAllController;
import br.com.lstecnologia.controller.profile.ProfileConsultIdController;
import br.com.lstecnologia.dto.response.ProfileResponseDTO;
import br.com.lstecnologia.model.ProfileModel;

@Component
public class ProfileAssembler extends RepresentationModelAssemblerSupport<ProfileModel, ProfileResponseDTO> {

	@Autowired
	private ModelMapper modelMapper;

	public ProfileAssembler() {
		super(ProfileConsultAllController.class, ProfileResponseDTO.class);
	}

	@Override
	public ProfileResponseDTO toModel(ProfileModel profileModel) {

		ProfileResponseDTO profileResponseDTO = modelMapper.map(profileModel, ProfileResponseDTO.class);

		profileResponseDTO
				.add(linkTo(methodOn(ProfileConsultAllController.class)
						.getAll(0, profileModel.getName())).withRel("profiles"));

		profileResponseDTO
				.add(linkTo(methodOn(ProfileConsultIdController.class).getById(profileResponseDTO.getId()))
						.withSelfRel());

		return profileResponseDTO;
	}

	public ProfileResponseDTO toResponseDTO(ProfileModel profileModel) {
		return toModel(profileModel);
	}

}
