package br.com.lstecnologia.service.user;

import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.lstecnologia.dto.response.PageableResponseDTO;
import br.com.lstecnologia.dto.response.UserResponseDTO;
import br.com.lstecnologia.mapper.assembler.UserAssembler;
import br.com.lstecnologia.model.UserModel;
import br.com.lstecnologia.repository.UserRepository;

@Service
public class UserConsultAllService {
	
	private static final int PAGE_SIZE = 10;

	@Autowired
	private UserAssembler usuarioAssembler;
	
	@Autowired
	private UserRepository userRepository;
	
	public PageableResponseDTO<UserResponseDTO> getAll(Integer pageNumber, String email, String name) {
		
		Pageable pageable = PageRequest.of(Objects.isNull(pageNumber) ? 0 : pageNumber, PAGE_SIZE);
		
		if(ObjectUtils.isNotEmpty(email) && ObjectUtils.isNotEmpty(name)) 
			return pageUser(userRepository.findByUsernameAndNameContaining(pageable, email, name));
		
		if(ObjectUtils.isNotEmpty(email) && ObjectUtils.isNotEmpty(name)) 
			return pageUser(userRepository.findByUsernameAndNameContaining(pageable, email, name));
		
		if(ObjectUtils.isNotEmpty(email)) 
			return pageUser(userRepository.findAllByUsername(pageable, email));
		
		if(ObjectUtils.isNotEmpty(name)) 
			return pageUser(userRepository.findByNameContaining(pageable, name));
		
		return pageUser(userRepository.findAll(pageable));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private PageableResponseDTO<UserResponseDTO> pageUser(Page<UserModel> list) {
		return new PageableResponseDTO(list, list.stream()
				.map(user -> usuarioAssembler.toResponseDTO(user))
				.collect(Collectors.toList()));
	}

}
