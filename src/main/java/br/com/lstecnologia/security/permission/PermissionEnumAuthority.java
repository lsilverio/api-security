package br.com.lstecnologia.security.permission;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PermissionEnumAuthority {

	PERMISSION_CONSULT_ALL("PERMISSION_CONSULT_ALL"),
	PERMISSION_CONSULT_BY_ID("PERMISSION_CONSULT_BY_ID"),
	PERMISSION_UPDATE("PERMISSION_UPDATE"),
	PERMISSION_DELETE("PERMISSION_DELETE");

	String description;

	PermissionEnumAuthority(String description) {
		this.description = description;
	}

	@JsonValue
	public String getDescription() {
		return description;
	}

	@JsonCreator
	public static PermissionEnumAuthority decode(final String description) {
		return Stream.of(PermissionEnumAuthority.values())
				.filter(targetEnum -> targetEnum.description.equals(description))
				.findFirst()
				.orElse(null);
	}

}
