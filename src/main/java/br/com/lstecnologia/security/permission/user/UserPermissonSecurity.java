package br.com.lstecnologia.security.permission.user;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserPermissonSecurity {

	CONSULT_ALL_USERS("CONSULT_ALL_USERS"),
	CONSULT_ALL_BY_ID_USERS("CONSULT_ALL_BY_ID_USERS"),
	CONSULT_BY_ID_USERS("CONSULT_BY_ID_USERS"),
	UPDATE_USERS("UPDATE_USERS"),
	DELETE_USERS("DELETE_USERS");

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
