package br.com.lstecnologia.controller.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.controller.BaseController;
import br.com.lstecnologia.dto.response.PermissionResponseDTO;
import br.com.lstecnologia.openapi.response.OpenApiResponseOk;
import br.com.lstecnologia.security.permission.PermissionAuthority;
import br.com.lstecnologia.service.permission.PermissionConsultIdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Permission", description = " ")
@RestController
@RequestMapping(value = "/permissions", produces = MediaType.APPLICATION_JSON_VALUE)
public class PermissionConsultIdController extends BaseController {
	
	@Autowired
	private PermissionConsultIdService permissionConsultIdService;
	
	@OpenApiResponseOk
	@PermissionAuthority.Permission.ConsultById
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Get permission by id", response = PermissionResponseDTO.class)
	public ResponseEntity<Object> getById(
			@ApiParam(name = "id", value = "Permission id", required = true) @PathVariable Long id) {
		return ok(permissionConsultIdService.getById(id));
	}
	
}
