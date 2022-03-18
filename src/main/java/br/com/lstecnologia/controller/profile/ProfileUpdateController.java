package br.com.lstecnologia.controller.profile;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.request.profile.ProfileUpdateRequestDTO;
import br.com.lstecnologia.openapi.response.OpenApiResponseNoContent;
import br.com.lstecnologia.security.permission.profile.ProfileAuthority;
import br.com.lstecnologia.service.profile.ProfileUpdateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Profile", description = " ")
@RestController
@RequestMapping(value = "/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileUpdateController extends BaseController {
	
	@Autowired
	private ProfileUpdateService profileUpdateService;
	
	@OpenApiResponseNoContent
	@ProfileAuthority.Permission.Update
	@PutMapping(value = "/{id}")
	@ApiOperation(value = "Update profile", response = Void.class)
	public ResponseEntity<Void> update(
			@ApiParam(name = "id", value = "Profile id", required = true) @PathVariable Long id, 
			@ApiParam(name = "ProfileUpdateRequestDTO", 
			value = "Attributes are mandatory to perform profile update", 
			required = true)
			@Valid @RequestBody ProfileUpdateRequestDTO profileUpdateRequestDTO) {
		profileUpdateService.update(id, profileUpdateRequestDTO);
		return noContent();
	}
	
}
