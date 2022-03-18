package br.com.lstecnologia.service.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.response.PermissionResponseDTO;
import br.com.lstecnologia.exception.ObjectNotFoundException;
import br.com.lstecnologia.mapper.assembler.PermissionAssembler;
import br.com.lstecnologia.model.PermissionModel;
import br.com.lstecnologia.repository.PermissionRepository;

@Service
public class PermissionConsultIdService {
	
	@Autowired
	private PermissionAssembler permissionAssembler;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	public PermissionResponseDTO getById(Long id) {
		
		PermissionModel permissionModel = permissionRepository.findByIdAndExcludedFalse(id)
				.orElseThrow(() -> new ObjectNotFoundException("Permission not found using the given id"));
		
		return permissionAssembler.toResponseDTO(permissionModel);
	}

}
