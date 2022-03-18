package br.com.lstecnologia.service.permission;

import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.response.PageableResponseDTO;
import br.com.lstecnologia.dto.response.PermissionResponseDTO;
import br.com.lstecnologia.mapper.assembler.PermissionAssembler;
import br.com.lstecnologia.model.PermissionModel;
import br.com.lstecnologia.repository.PermissionRepository;

@Service
public class PermissionConsultAllService {
	
	private static final int PAGE_SIZE = 10;

	@Autowired
	private PermissionAssembler permissionAssembler;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	public PageableResponseDTO<PermissionResponseDTO> getAll(Integer pageNumber, String name) {
		
		Pageable pageable = PageRequest.of(Objects.isNull(pageNumber) ? 0 : pageNumber, PAGE_SIZE);
		
		if(ObjectUtils.isNotEmpty(name)) 
			return pagePermission(permissionRepository.findByNameContaining(pageable, name));
		
		return pagePermission(permissionRepository.findAll(pageable));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private PageableResponseDTO<PermissionResponseDTO> pagePermission(Page<PermissionModel> list) {
		return new PageableResponseDTO(list, list.stream()
				.map(permission -> permissionAssembler.toResponseDTO(permission))
				.collect(Collectors.toList()));
	}

}
