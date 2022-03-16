package br.com.lstecnologia.dto.response;

import java.util.List;

import org.springframework.data.domain.Page;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PageableResponseDTO<T> {
	
	@ApiModelProperty(value = "Total records")
	private long totalRecords;
	
	@ApiModelProperty(value = "Total pages")
	private int totalPages;
	
	@ApiModelProperty(value = "Total records on current page")
	private int totalRecordsCurrentPage;
	
	@ApiModelProperty(value = "Last page")
	private boolean lastPage;
	
	@ApiModelProperty(value = "First page")
	private boolean firstPage;
	
	@ApiModelProperty(value = "Number current page")
	private int numberCurrentPage;
	
	@ApiModelProperty(value = "Records")
	private List<T> records;
	
	public PageableResponseDTO (Page<T> list, List<T> records) {
		this.totalPages = list.getTotalPages();
		this.totalRecords = list.getTotalElements();
		this.totalRecordsCurrentPage = list.getNumberOfElements();
		this.numberCurrentPage = list.getNumber();
		this.firstPage = list.isFirst();
		this.lastPage = list.isLast();
		this.records = records;
	}

}
