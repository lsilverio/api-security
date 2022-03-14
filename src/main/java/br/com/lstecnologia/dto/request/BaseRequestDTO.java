package br.com.lstecnologia.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequestDTO {
	
	@ApiModelProperty(value = "Registro ativo", example = "true ou false")
	private boolean ativo = true;
	
	@ApiModelProperty(value = "Justificativa da inativacao")
	private String justificativaInativacao;

}
