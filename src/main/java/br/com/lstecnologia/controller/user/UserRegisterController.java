package br.com.lstecnologia.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.request.UserRegisterRequestDTO;
import br.com.lstecnologia.dto.response.UserResponseDTO;
import br.com.lstecnologia.service.user.UserRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "User", description = " ")
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRegisterController extends BaseController {
	
	@Autowired
	private UserRegisterService userRegisterService;
	
	@ApiOperation(value = "Register new user", response = UserResponseDTO.class)
	@PostMapping
	public ResponseEntity<Object> register(@Valid @RequestBody UserRegisterRequestDTO userRegisterRequestDTO) {
		UserResponseDTO userResponseDto = userRegisterService.register(userRegisterRequestDTO);
		return created(userResponseDto, userResponseDto.getId());
	}
	
}
