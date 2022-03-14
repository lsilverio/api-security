package br.com.lstecnologia.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileResponseDto extends BaseResponseDto {

	
	@ApiModelProperty(value = "Nome do usuario")
	private String nome;
	
	@ApiModelProperty(value = "username do usuario")
	private String username;
	
}
