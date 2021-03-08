package br.com.araujo.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.araujo.dto.HealthCheckDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(tags = "HealthCheck")
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class HealthCheckController {
	
	@GetMapping
	@ApiOperation(value = "Endpoint para health check da API", response = HealthCheckDTO.class)
	public ResponseEntity<Object> check() {

		log.info("Health Check: " + LocalDateTime.now());
		
		HealthCheckDTO checkDTO = HealthCheckDTO.builder()
				.application("Ecommerce Produto")
				.status(HttpStatus.OK.value())
				.message("Health")
				.build();
		
		return ResponseEntity.ok().body(checkDTO);
	}

}
