package br.com.lstecnologia.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.response.UserResponseDTO;
import br.com.lstecnologia.security.permission.UserSecurity;
import br.com.lstecnologia.service.user.UserConsultAllService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "User", description = " ")
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserConsultAllController extends BaseController {
	
	@Autowired
	private UserConsultAllService userConsultAllService;
	
	@UserSecurity.Permission.ConsultAll
	@GetMapping
	@ApiOperation(value = "Get all users", response = UserResponseDTO[].class)
	public ResponseEntity<Object> getAll() {
		return ok(userConsultAllService.getAll());
	}
	
}
