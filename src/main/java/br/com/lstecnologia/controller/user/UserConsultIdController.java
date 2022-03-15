package br.com.lstecnologia.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.response.UserResponseDTO;
import br.com.lstecnologia.security.permission.UserSecurity;
import br.com.lstecnologia.service.user.UserConsultIdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "User")
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserConsultIdController extends BaseController {
	
	@Autowired
	private UserConsultIdService userConsultIdService;
	
	@UserSecurity.Permission.ConsultById
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Get user by id", response = UserResponseDTO.class)
	public ResponseEntity<Object> getById(@PathVariable Long id) {
		return ok(userConsultIdService.getById(id));
	}
	
}
