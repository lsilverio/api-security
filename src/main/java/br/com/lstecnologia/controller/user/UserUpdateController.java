package br.com.lstecnologia.controller.user;

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
import br.com.lstecnologia.dto.request.user.UserUpdateRequestDTO;
import br.com.lstecnologia.openapi.response.OpenApiResponseNoContent;
import br.com.lstecnologia.security.permission.user.UserAuthority;
import br.com.lstecnologia.service.user.UserUpdateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "User", description = " ")
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserUpdateController extends BaseController {
	
	@Autowired
	private UserUpdateService userUpdateService;
	
	@OpenApiResponseNoContent
	@UserAuthority.Permission.Update
	@PutMapping(value = "/{id}")
	@ApiOperation(value = "Update user", response = Void.class)
	public ResponseEntity<Void> update(
			@ApiParam(name = "id", value = "User id", required = true) @PathVariable Long id, 
			@ApiParam(name = "UserUpdateRequestDTO", 
			value = "Attributes are mandatory to perform user update", 
			required = true)
			@Valid @RequestBody UserUpdateRequestDTO userUpdateRequestDTO) {
		userUpdateService.update(id, userUpdateRequestDTO);
		return noContent();
	}
	
}
