package br.com.lstecnologia.security.permission.user;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserEnumAuthority {

	USER_CONSULT_ALL("USER_CONSULT_ALL"),
	USER_CONSULT_ALL_BY_ID("USER_CONSULT_ALL_BY_ID"),
	USER_CONSULT_BY_ID("USER_CONSULT_BY_ID"),
	USER_UPDATE("USER_UPDATE"),
	DELETE_USER("USER_DELETE"),
	USER_ADD_PROFILE("USER_ADD_PROFILE"),
	USER_REMOVE_PROFILE("USER_REMOVE_PROFILE");

	String description;

	UserEnumAuthority(String description) {
		this.description = description;
	}

	@JsonValue
	public String getDescription() {
		return description;
	}

	@JsonCreator
	public static UserEnumAuthority decode(final String description) {
		return Stream.of(UserEnumAuthority.values())
				.filter(targetEnum -> targetEnum.description.equals(description))
				.findFirst()
				.orElse(null);
	}

}
