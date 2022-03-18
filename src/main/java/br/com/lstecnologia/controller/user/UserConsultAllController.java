package br.com.lstecnologia.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.response.PageableResponseDTO;
import br.com.lstecnologia.openapi.response.OpenApiResponseOk;
import br.com.lstecnologia.security.permission.user.UserAuthority;
import br.com.lstecnologia.service.user.UserConsultAllService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "User", description = " ")
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserConsultAllController extends BaseController {
	
	@Autowired
	private UserConsultAllService userConsultAllService;
	
	@OpenApiResponseOk
	@UserAuthority.Permission.ConsultAll
	@GetMapping
	@ApiOperation(value = "Get all users", response = PageableResponseDTO.class)
	public ResponseEntity<Object> getAll(
			@ApiParam(name = "numberPage", value = "Page number", required = false) 
			@RequestParam(required = false, value = "numberPage") Integer numberPage, 
			
			@ApiParam(name = "email", value = "Email", required = false) 
			@RequestParam(required = false, value = "email") String email,
			
			@ApiParam(name = "name", value = "Name", required = false) 
			@RequestParam(required = false, value = "name") String name) {
		
		return ok(userConsultAllService.getAll(numberPage, email, name));
	}
	
}
