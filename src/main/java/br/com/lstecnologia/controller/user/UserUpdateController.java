package br.com.lstecnologia.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.request.UserRequestDto;
import br.com.lstecnologia.security.permission.UserSecurity;
import br.com.lstecnologia.service.user.UserUpdateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "User")
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserUpdateController extends BaseController {
	
	@Autowired
	private UserUpdateService userUpdateService;
	
	@UserSecurity.Permission.Update
	@PutMapping(value = "/{id}")
	@ApiOperation(value = "Update user", response = Void.class)
	public ResponseEntity<Void> register(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
		userUpdateService.update(id, userRequestDto);
		return noContent();
	}
	
}
