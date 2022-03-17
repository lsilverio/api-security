package br.com.lstecnologia.dto.request.user;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserEmailRequestDTO {
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "Email", required = true)
	private String email;

}
