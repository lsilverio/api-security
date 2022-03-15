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
import br.com.lstecnologia.dto.request.NewPasswordUserRequestDTO;
import br.com.lstecnologia.service.user.UserPasswordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "User")
@RestController
@RequestMapping(value = "/users/passwords", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserPasswordController extends BaseController {
	
	@Autowired
	private UserPasswordService userPasswordService;
	
	@PutMapping
	@ApiOperation(value = "New password", response = Void.class)
	public ResponseEntity<Void> newPassword(@Valid @RequestBody NewPasswordUserRequestDTO newPasswordUserRequestDTO) {
		userPasswordService.newPassword(newPasswordUserRequestDTO);
		return noContent();
	}
	
}
