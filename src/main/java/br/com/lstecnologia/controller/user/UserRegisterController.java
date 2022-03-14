package br.com.lstecnologia.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.request.UserRequestDto;
import br.com.lstecnologia.dto.response.UserResponseDto;
import br.com.lstecnologia.security.UserSecurity;
import br.com.lstecnologia.service.user.UserRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "User")
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRegisterController extends BaseController {
	
	@Autowired
	private UserRegisterService userRegisterService;
	
	@UserSecurity.Permission.Register
	@PostMapping
	@ApiOperation(value = "Register new user", response = UserResponseDto.class)
	public ResponseEntity<Object> register(@RequestBody UserRequestDto usuarioDto) {
		UserResponseDto userResponseDto = userRegisterService.register(usuarioDto);
		return created(userResponseDto, userResponseDto.getId());
	}
	
}
