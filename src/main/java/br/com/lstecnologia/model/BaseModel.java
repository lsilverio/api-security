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
	
	/**
	 * Column that stores the id information of the user who made the last change to the registry
	 */
	@Column(name = "user_id")
	private Long userId;
	
	/**
	 * Column that stores the information if the record is considered deleted
	 */
	@Column(name = "excluded")
	private boolean excluded = Boolean.FALSE;
	
	/**
	 * Column that stores the information if the record is considered active
	 */
	@Column(name = "active")
	private boolean active = Boolean.TRUE;
	
	/**
	 * Column that stores the information by which the record was inactivated
	 */
	@Column(columnDefinition = "TEXT", name = "justification_inactivation")
	@Type(type = "text")
	private String justificationInactivation;

	/**
	 * Column that stores the creation date information
	 */
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "timestamp", name = "creation_date")
	private LocalDateTime creationDate;
	
	/**
	 * Column that stores the last change date information
	 */
	@UpdateTimestamp
	@Column(nullable = false, columnDefinition = "timestamp", name = "change_date")
	private LocalDateTime changeDate;

}
