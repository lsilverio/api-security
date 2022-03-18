package br.com.lstecnologia.controller.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.response.ProfileResponseDTO;
import br.com.lstecnologia.openapi.response.OpenApiResponseOk;
import br.com.lstecnologia.security.permission.profile.ProfileAuthority;
import br.com.lstecnologia.service.profile.ProfileConsultIdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Profile", description = " ")
@RestController
@RequestMapping(value = "/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileConsultIdController extends BaseController {
	
	@Autowired
	private ProfileConsultIdService profileConsultIdService;
	
	@OpenApiResponseOk
	@ProfileAuthority.Permission.ConsultById
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Get profile by id", response = ProfileResponseDTO.class)
	public ResponseEntity<Object> getById(
			@ApiParam(name = "id", value = "Profile id", required = true) @PathVariable Long id) {
		return ok(profileConsultIdService.getById(id));
	}
	
}
