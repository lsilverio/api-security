package br.com.lstecnologia.service.profile;

import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.response.PageableResponseDTO;
import br.com.lstecnologia.dto.response.ProfileResponseDTO;
import br.com.lstecnologia.mapper.assembler.ProfileAssembler;
import br.com.lstecnologia.model.ProfileModel;
import br.com.lstecnologia.repository.ProfileRepository;

@Service
public class ProfileConsultAllService {
	
	private static final int PAGE_SIZE = 10;

	@Autowired
	private ProfileAssembler profileAssembler;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public PageableResponseDTO<ProfileResponseDTO> getAll(Integer pageNumber, String name) {
		
		Pageable pageable = PageRequest.of(Objects.isNull(pageNumber) ? 0 : pageNumber, PAGE_SIZE);
		
		if(ObjectUtils.isNotEmpty(name)) 
			return pageProfile(profileRepository.findByNameContaining(pageable, name));
		
		return pageProfile(profileRepository.findAll(pageable));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private PageableResponseDTO<ProfileResponseDTO> pageProfile(Page<ProfileModel> list) {
		return new PageableResponseDTO(list, list.stream()
				.map(profile -> profileAssembler.toResponseDTO(profile))
				.collect(Collectors.toList()));
	}

}
