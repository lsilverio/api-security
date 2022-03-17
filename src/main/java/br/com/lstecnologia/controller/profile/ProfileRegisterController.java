package br.com.lstecnologia.controller.profile;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.request.profile.ProfileRegisterRequestDTO;
import br.com.lstecnologia.dto.response.ProfileResponseDTO;
import br.com.lstecnologia.openapi.response.OpenApiResponseCreated;
import br.com.lstecnologia.service.profile.ProfileRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Profile", description = " ")
@RestController
@RequestMapping(value = "/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileRegisterController extends BaseController {
	
	@Autowired
	private ProfileRegisterService profileRegisterService;
	
	@OpenApiResponseCreated
	@ApiOperation(value = "Register new profile", response = ProfileResponseDTO.class)
	@PostMapping
	public ResponseEntity<Object> register(
			@ApiParam(name = "ProfileRegisterRequestDTO", 
			value = "Attributes are mandatory to perform profile registration", 
			required = true) 
			@Valid @RequestBody ProfileRegisterRequestDTO profileRegisterRequestDTO) {
		ProfileResponseDTO profileResponseDto = profileRegisterService.register(profileRegisterRequestDTO);
		return created(profileResponseDto, profileResponseDto.getId());
	}
	
}
