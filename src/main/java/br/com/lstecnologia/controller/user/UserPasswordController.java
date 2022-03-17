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
import br.com.lstecnologia.dto.request.user.UserNewPasswordRequestDTO;
import br.com.lstecnologia.openapi.response.OpenApiResponseNoContent;
import br.com.lstecnologia.service.user.UserPasswordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "User", description = " ")
@RestController
@RequestMapping(value = "/users/passwords", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserPasswordController extends BaseController {
	
	@Autowired
	private UserPasswordService userPasswordService;
	
	@OpenApiResponseNoContent
	@PutMapping
	@ApiOperation(value = "New password", response = Void.class)
	public ResponseEntity<Void> newPassword(
			@ApiParam(name = "UserNewPasswordRequestDTO", 
			value = "Attributes are mandatory to perform password update", 
			required = true) 
			@Valid @RequestBody UserNewPasswordRequestDTO userNewPasswordRequestDTO) {
		userPasswordService.newPassword(userNewPasswordRequestDTO);
		return noContent();
	}
	
}
