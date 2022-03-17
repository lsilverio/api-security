package br.com.lstecnologia.security.permission.profile;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProfilePermissonSecurity {

	CONSULT_ALL_PROFILES("CONSULT_ALL_PROFILES"),
	CONSULT_ALL_BY_ID_PROFILES("CONSULT_ALL_BY_ID_PROFILES"),
	CONSULT_BY_ID_PROFILES("CONSULT_BY_ID_PROFILES"),
	UPDATE_PROFILES("UPDATE_PROFILES"),
	DELETE_PROFILES("DELETE_PROFILES");

	String description;

	ProfilePermissonSecurity(String description) {
		this.description = description;
	}

	@JsonValue
	public String getDescription() {
		return description;
	}

	@JsonCreator
	public static ProfilePermissonSecurity decode(final String description) {
		return Stream.of(ProfilePermissonSecurity.values())
				.filter(targetEnum -> targetEnum.description.equals(description))
				.findFirst()
				.orElse(null);
	}

}
