package br.com.lstecnologia.security.permission.user;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserPermissonSecurity {

	USER_CONSULT_ALL("USER_CONSULT_ALL"),
	USER_CONSULT_ALL_BY_ID("USER_CONSULT_ALL_BY_ID"),
	USER_CONSULT_BY_ID("USER_CONSULT_BY_ID"),
	USER_UPDATE("USER_UPDATE"),
	DELETE_USER("USER_DELETE");

	String description;

	UserPermissonSecurity(String description) {
		this.description = description;
	}

	@JsonValue
	public String getDescription() {
		return description;
	}

	@JsonCreator
	public static UserPermissonSecurity decode(final String description) {
		return Stream.of(UserPermissonSecurity.values())
				.filter(targetEnum -> targetEnum.description.equals(description))
				.findFirst()
				.orElse(null);
	}

}
