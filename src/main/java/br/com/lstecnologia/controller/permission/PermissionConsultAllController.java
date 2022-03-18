package br.com.lstecnologia.controller.permission;

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
import br.com.lstecnologia.security.permission.PermissionAuthority;
import br.com.lstecnologia.service.permission.PermissionConsultAllService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Permission", description = " ")
@RestController
@RequestMapping(value = "/permissions", produces = MediaType.APPLICATION_JSON_VALUE)
public class PermissionConsultAllController extends BaseController {
	
	@Autowired
	private PermissionConsultAllService permissionConsultAllService;
	
	@OpenApiResponseOk
	@PermissionAuthority.Permission.ConsultAll
	@GetMapping
	@ApiOperation(value = "Get all Permissions", response = PageableResponseDTO.class)
	public ResponseEntity<Object> getAll(
			@ApiParam(name = "numberPage", value = "Page number", required = false) 
			@RequestParam(required = false, value = "numberPage") Integer numberPage,
			
			@ApiParam(name = "name", value = "Name", required = false) 
			@RequestParam(required = false, value = "name") String name) {
		
		return ok(permissionConsultAllService.getAll(numberPage, name));
	}
	
}
