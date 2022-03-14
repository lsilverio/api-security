package br.com.lstecnologia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lstecnologia.dto.HealthCheckDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "HealthCheck")
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class HealthCheckController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping
	@ApiOperation(value = "Health check - API", response = HealthCheckDto.class)
	public ResponseEntity<Object> check() {

		String application = environment.getProperty("spring.application.name");
		
		HealthCheckDto checkDTO = HealthCheckDto.builder()
				.application(application)
				.status(HttpStatus.OK.value())
				.message("Health")
				.build();
		
		return ResponseEntity.ok().body(checkDTO);
	}

}