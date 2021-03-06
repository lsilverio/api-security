package br.com.lstecnologia.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.openapi.response.OpenApiResponseNoContent;
import br.com.lstecnologia.security.permission.user.UserAuthority;
import br.com.lstecnologia.service.user.UserDeleteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "User", description = " ")
@RestController
@RequestMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserDeleteController extends BaseController {
	
	@Autowired
	private UserDeleteService deleteUserService;
	
	@OpenApiResponseNoContent
	@UserAuthority.Permission.Delete
	@DeleteMapping
	@ApiOperation(value = "Delete user by id", response = Void.class)
	public ResponseEntity<Void> deleteById(
			@ApiParam(name = "id", value = "User id", required = true) @PathVariable Long id) {
		deleteUserService.deleteById(id);
		return noContent();
	}
	
}
