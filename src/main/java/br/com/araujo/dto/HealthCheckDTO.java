package br.com.araujo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HealthCheckDTO {

	private String application;
	private int status;
	private String message;
	
}
