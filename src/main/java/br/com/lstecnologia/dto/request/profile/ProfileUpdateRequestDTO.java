package br.com.lstecnologia.dto.request.profile;

import javax.validation.constraints.NotEmpty;

import br.com.lstecnologia.dto.request.BaseRequestDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProfileUpdateRequestDTO extends BaseRequestDTO {
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "Name", required = true)
	private String name;
	
	@NotEmpty(message = "Is required")
	@ApiModelProperty(value = "Description", required = true)
	private String description;

}
