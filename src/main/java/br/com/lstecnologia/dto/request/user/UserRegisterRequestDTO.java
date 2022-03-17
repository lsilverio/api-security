package br.com.lstecnologia.dto.request.user;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegisterRequestDTO {
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "Name", required = true)
	private String name;
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "Email", required = true, example = "email@email.com")
	private String email;
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "Email confirmation", required = true, example = "email@email.com")
	private String emailConfirmation;
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "Password", required = true)
	private String password;
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "Password confirmation", required = true)
	private String passwordConfirmation;

}
