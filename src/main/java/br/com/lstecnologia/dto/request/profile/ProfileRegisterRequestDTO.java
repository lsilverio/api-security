package br.com.lstecnologia.dto.request.profile;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProfileRegisterRequestDTO {
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "Name", required = true)
	private String name;
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "Description", required = true)
	private String description;

}
