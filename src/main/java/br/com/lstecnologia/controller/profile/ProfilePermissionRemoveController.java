package br.com.lstecnologia.controller.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.openapi.response.OpenApiResponseCreated;
import br.com.lstecnologia.security.permission.profile.ProfileAuthority;
import br.com.lstecnologia.service.profile.ProfilePermissionRemoveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Profile - Permission", description = " ")
@RestController
@RequestMapping(value = "/profiles/{profileId}/permissions/{permissionId}", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfilePermissionRemoveController extends BaseController {
	
	@Autowired
	private ProfilePermissionRemoveService profilePermissionRemoveService;
	
	@ProfileAuthority.Permission.RemovePermission
	@OpenApiResponseCreated
	@ApiOperation(value = "Remove permission for the profile", response = Void.class)
	@DeleteMapping
	public ResponseEntity<Void> removePermission(
			@ApiParam(name = "profileId", value = "Profile id", required = true) @PathVariable Long profileId,
			@ApiParam(name = "permissionId", value = "Permission id", required = true) @PathVariable Long permissionId) {
		profilePermissionRemoveService.removePermission(profileId, permissionId);
		return noContent();
	}

}
