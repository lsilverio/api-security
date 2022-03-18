package br.com.lstecnologia.controller.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.response.PermissionResponseDTO;
import br.com.lstecnologia.openapi.response.OpenApiResponseCreated;
import br.com.lstecnologia.security.permission.profile.ProfileAuthority;
import br.com.lstecnologia.service.profile.ProfilePermissionConsultAllService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Profile - Permission", description = " ")
@RestController
@RequestMapping(value = "/profiles/{profileId}/permissions", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfilePermissionConsultAllController extends BaseController {
	
	@Autowired
	private ProfilePermissionConsultAllService profilePermissionConsultAllService;
	
	@ProfileAuthority.Permission.AddPermission
	@OpenApiResponseCreated
	@ApiOperation(value = "Consult all permission for the profile", response = PermissionResponseDTO[].class)
	@GetMapping
	public ResponseEntity<Object> addPermission(
			@ApiParam(name = "profileId", value = "Profile id", required = true) @PathVariable Long profileId) {
		return ok(profilePermissionConsultAllService.consultAllPermission(profileId));
	}

}
