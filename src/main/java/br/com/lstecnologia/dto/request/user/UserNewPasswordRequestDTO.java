package br.com.lstecnologia.dto.request.user;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserNewPasswordRequestDTO {
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "UUID", required = true)
	private String uuid;
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "Password", required = true)
	private String password;
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "Password confirmation", required = true)
	private String passwordConfirmation;

}
