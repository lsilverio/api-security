package br.com.lstecnologia.dto.response;

import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponseDto extends RepresentationModel<BaseResponseDto> {
	
	@ApiModelProperty(value = "Id da tabela no banco de dados")
	private Long id;
	
	@ApiModelProperty(value = "Data de inserção")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataInsercao;
	
	@ApiModelProperty(value = "Data de alteracao")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataAlteracao;
	
	@ApiModelProperty(value = "Registro ativo", example = "true ou false")
	private boolean ativo = true;
	
	@ApiModelProperty(value = "Justificativa da inativacao")
	private String justificativaInativacao;

}
