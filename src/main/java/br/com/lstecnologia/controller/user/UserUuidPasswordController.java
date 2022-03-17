package br.com.lstecnologia.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.request.user.UserEmailRequestDTO;
import br.com.lstecnologia.openapi.response.OpenApiResponseNoContent;
import br.com.lstecnologia.service.user.UserUuidPasswordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "User", description = " ")
@RestController
@RequestMapping(value = "/users/passwords", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserUuidPasswordController extends BaseController {
	
	@Autowired
	private UserUuidPasswordService userUuidPasswordService;
	
	@OpenApiResponseNoContent
	@PutMapping(value = "/generate-uuid")
	@ApiOperation(value = "Generate uuid for password update", response = Void.class)
	public ResponseEntity<Void> generateCode(
			@ApiParam(name = "id", value = "User id", required = true) @PathVariable Long id, 
			@ApiParam(name = "UserEmailRequestDTO", 
			value = "Attributes are required to generate the uuid to proceed with the password update process", 
			required = true)
			@Valid @RequestBody UserEmailRequestDTO userEmailRequestDTO) {
		userUuidPasswordService.generateCode(userEmailRequestDTO);
		return noContent();
	}
	
}
