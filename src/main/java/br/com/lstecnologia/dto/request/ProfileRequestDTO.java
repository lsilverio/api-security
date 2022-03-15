package br.com.lstecnologia.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProfileRequestDTO extends BaseRequestDTO {
	
	@ApiModelProperty(value = "Nome do user")
	private String nome;
	
	@ApiModelProperty(value = "username do user")
	private String username;
	
	@ApiModelProperty(value = "password do user")
	private String password;

}
