package br.com.lstecnologia.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.response.UserResponseDto;
import br.com.lstecnologia.security.UserSecurity;
import br.com.lstecnologia.service.user.UserConsultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "User")
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserConsultController extends BaseController {
	
	@Autowired
	private UserConsultService userService;
	
	@UserSecurity.Permission.Consult
	@GetMapping
	@ApiOperation(value = "Get all users", response = UserResponseDto[].class)
	public ResponseEntity<Object> getAll() {
		return ok(userService.getAll());
	}
	
	@UserSecurity.Permission.Consult
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Get user by id", response = UserResponseDto.class)
	public ResponseEntity<Object> getById(@PathVariable Long id) {
		return ok(userService.getById(id));
	}
	
}
