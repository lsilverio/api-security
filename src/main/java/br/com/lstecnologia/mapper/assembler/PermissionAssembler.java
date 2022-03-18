package br.com.lstecnologia.mapper.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.lstecnologia.controller.permission.PermissionConsultAllController;
import br.com.lstecnologia.controller.permission.PermissionConsultIdController;
import br.com.lstecnologia.dto.response.PermissionResponseDTO;
import br.com.lstecnologia.model.PermissionModel;

@Component
public class PermissionAssembler extends RepresentationModelAssemblerSupport<PermissionModel, PermissionResponseDTO> {

	@Autowired
	private ModelMapper modelMapper;

	public PermissionAssembler() {
		super(PermissionConsultAllController.class, PermissionResponseDTO.class);
	}

	@Override
	public PermissionResponseDTO toModel(PermissionModel permissionModel) {

		PermissionResponseDTO permissionResponseDTO = modelMapper.map(permissionModel, PermissionResponseDTO.class);

		permissionResponseDTO
				.add(linkTo(methodOn(PermissionConsultAllController.class)
						.getAll(0, permissionModel.getName())).withRel("permissions"));

		permissionResponseDTO
				.add(linkTo(methodOn(PermissionConsultIdController.class).getById(permissionResponseDTO.getId()))
						.withSelfRel());

		return permissionResponseDTO;
	}

	public PermissionResponseDTO toResponseDTO(PermissionModel permissionModel) {
		return toModel(permissionModel);
	}

}
