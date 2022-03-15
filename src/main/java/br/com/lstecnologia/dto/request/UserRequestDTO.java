package br.com.lstecnologia.dto.request;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRequestDTO extends BaseRequestDTO {
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "Name", required = true)
	private String name;
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "Email", required = true, example = "email@email.com")
	private String email;
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "Email confirmation", required = true, example = "email@email.com")
	private String emailConfirmation;

}
