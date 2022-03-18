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
import br.com.lstecnologia.security.permission.user.UserAuthority;
import br.com.lstecnologia.service.user.UserProfileRemoveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "User - Profile", description = " ")
@RestController
@RequestMapping(value = "/users/{userId}/profiles/{profileId}", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfilePermissionRemoveController extends BaseController {
	
	@Autowired
	private UserProfileRemoveService userProfileRemoveService;
	
	@UserAuthority.Permission.RemoveProfile
	@OpenApiResponseCreated
	@ApiOperation(value = "Remove profile for the user", response = Void.class)
	@DeleteMapping
	public ResponseEntity<Void> removeProfile(
			@ApiParam(name = "userId", value = "User id", required = true) @PathVariable Long userId,
			@ApiParam(name = "profileId", value = "Profile id", required = true) @PathVariable Long profileId) {
		userProfileRemoveService.removeProfile(userId, profileId);
		return noContent();
	}

}
