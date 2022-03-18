package br.com.lstecnologia.security.permission.profile;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProfileEnumAuthority {

	PROFILE_CONSULT_ALL("PROFILE_CONSULT_ALL"),
	PROFILE_CONSULT_BY_ID("PROFILE_CONSULT_BY_ID"),
	PROFILE_REGISTER("PROFILE_REGISTER"),
	PROFILE_UPDATE("PROFILE_UPDATE"),
	PROFILE_DELETE("PROFILE_DELETE");

	String description;

	ProfileEnumAuthority(String description) {
		this.description = description;
	}

	@JsonValue
	public String getDescription() {
		return description;
	}

	@JsonCreator
	public static ProfileEnumAuthority decode(final String description) {
		return Stream.of(ProfileEnumAuthority.values())
				.filter(targetEnum -> targetEnum.description.equals(description))
				.findFirst()
				.orElse(null);
	}

}
