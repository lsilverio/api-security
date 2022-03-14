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
	
	@ApiModelProperty(value = "Table id in the database")
	private Long id;
	
	@ApiModelProperty(value = "Change date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime changeDate;
	
	@ApiModelProperty(value = "Creation date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime creationDate;
	
	@ApiModelProperty(value = "Active", example = "true ou false")
	private boolean active = true;
	
	@ApiModelProperty(value = "Justification of inactivation")
	private String justificationInactivation;

}
