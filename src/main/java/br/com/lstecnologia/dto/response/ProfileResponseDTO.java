package br.com.lstecnologia.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProfileResponseDTO extends BaseResponseDTO {
	
	@ApiModelProperty(value = "Name")
	private String name;
	
	@ApiModelProperty(value = "Description")
	private String description;
	
}
