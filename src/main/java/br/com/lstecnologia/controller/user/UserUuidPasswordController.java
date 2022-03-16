package br.com.lstecnologia.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.request.UserEmailRequestDTO;
import br.com.lstecnologia.service.user.UserUuidPasswordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "User", description = " ")
@RestController
@RequestMapping(value = "/users/passwords", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserUuidPasswordController extends BaseController {
	
	@Autowired
	private UserUuidPasswordService userUuidPasswordService;
	
	@PutMapping(value = "/generate-uuid")
	@ApiOperation(value = "Generate uuid for password update", response = Void.class)
	public ResponseEntity<Void> generateCode(@Valid @RequestBody UserEmailRequestDTO userEmailRequestDTO) {
		userUuidPasswordService.generateCode(userEmailRequestDTO);
		return noContent();
	}
	
}
