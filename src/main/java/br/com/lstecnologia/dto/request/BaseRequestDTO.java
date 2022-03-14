package br.com.lstecnologia.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequestDTO {
	
	@ApiModelProperty(value = "Active", example = "true ou false")
	private boolean active = true;
	
	@ApiModelProperty(value = "Justification of inactivation")
	private String justificationInactivation;

}
