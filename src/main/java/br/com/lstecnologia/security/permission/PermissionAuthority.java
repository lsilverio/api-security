package br.com.lstecnologia.security.permission;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public @interface PermissionAuthority {

	public @interface Permission {
		
		@PreAuthorize("hasAuthority('PERMISSION_CONSULT_ALL')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface ConsultAll { }
		
		@PreAuthorize("hasAuthority('PERMISSION_CONSULT_BY_ID')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface ConsultById { }
		
		@PreAuthorize("hasAuthority('PERMISSION_UPDATE')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface Update { }

		@PreAuthorize("hasAuthority('PERMISSION_DELETE')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface Delete { }
		
	}
	
}
