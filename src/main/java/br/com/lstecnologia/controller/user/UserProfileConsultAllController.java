package br.com.lstecnologia.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.response.ProfileResponseDTO;
import br.com.lstecnologia.openapi.response.OpenApiResponseCreated;
import br.com.lstecnologia.security.permission.user.UserAuthority;
import br.com.lstecnologia.service.user.UserProfileConsultAllService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "User - Profile", description = " ")
@RestController
@RequestMapping(value = "/users/{userId}/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserProfileConsultAllController extends BaseController {
	
	@Autowired
	private UserProfileConsultAllService userProfileConsultAllService;
	
	@UserAuthority.Permission.AddProfile
	@OpenApiResponseCreated
	@ApiOperation(value = "Consult all profile for the user", response = ProfileResponseDTO[].class)
	@GetMapping
	public ResponseEntity<Object> addProfile(
			@ApiParam(name = "userId", value = "User id", required = true) @PathVariable Long userId) {
		return ok(userProfileConsultAllService.consultAllProfile(userId));
	}

}
