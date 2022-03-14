package br.com.lstecnologia.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel implements Serializable {

	private static final long serialVersionUID = 6967241038577250988L;
	
	@Column(name = "excluded")
	private boolean excluded = Boolean.FALSE;
	
	@Column(name = "active")
	private boolean active = Boolean.TRUE;
	
	@Column(columnDefinition = "TEXT", name = "justification_inactivation")
	@Type(type = "text")
	private String justificationInactivation;

	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "timestamp", name = "creation_date")
	private LocalDateTime creationDate;
	
	@UpdateTimestamp
	@Column(nullable = false, columnDefinition = "timestamp", name = "change_date")
	private LocalDateTime changeDate;

}
