package br.com.lstecnologia.controller.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.response.PageableResponseDTO;
import br.com.lstecnologia.openapi.response.OpenApiResponseOk;
import br.com.lstecnologia.security.permission.profile.ProfileAuthority;
import br.com.lstecnologia.service.profile.ProfileConsultAllService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Profile", description = " ")
@RestController
@RequestMapping(value = "/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileConsultAllController extends BaseController {
	
	@Autowired
	private ProfileConsultAllService profileConsultAllService;
	
	@OpenApiResponseOk
	@ProfileAuthority.Permission.ConsultAll
	@GetMapping
	@ApiOperation(value = "Get all Profiles", response = PageableResponseDTO.class)
	public ResponseEntity<Object> getAll(
			@ApiParam(name = "numberPage", value = "Page number", required = false) 
			@RequestParam(required = false, value = "numberPage") Integer numberPage,
			
			@ApiParam(name = "name", value = "Name", required = false) 
			@RequestParam(required = false, value = "name") String name) {
		
		return ok(profileConsultAllService.getAll(numberPage, name));
	}
	
}
