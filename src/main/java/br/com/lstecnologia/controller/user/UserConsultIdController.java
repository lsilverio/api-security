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
import br.com.lstecnologia.openapi.response.OpenApiResponseOk;
import br.com.lstecnologia.security.permission.user.UserAuthority;
import br.com.lstecnologia.service.user.UserConsultIdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "User", description = " ")
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserConsultIdController extends BaseController {
	
	@Autowired
	private UserConsultIdService userConsultIdService;
	
	@OpenApiResponseOk
	@UserAuthority.Permission.ConsultById
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Get user by id", response = UserResponseDTO.class)
	public ResponseEntity<Object> getById(
			@ApiParam(name = "id", value = "User id", required = true) @PathVariable Long id) {
		return ok(userConsultIdService.getById(id));
	}
	
}
