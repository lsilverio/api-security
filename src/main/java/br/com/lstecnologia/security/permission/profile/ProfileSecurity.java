package br.com.lstecnologia.security.permission.profile;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public @interface ProfileSecurity {

	public @interface Permission {
		
		@PreAuthorize("hasAuthority('PROFILE_CONSULT_ALL')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface ConsultAll { }
		
		@PreAuthorize("hasAuthority('PROFILE_CONSULT_BY_ID')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface ConsultById { }
		
		@PreAuthorize("hasAuthority('PROFILE_UPDATE')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface Update { }

		@PreAuthorize("hasAuthority('PROFILE_DELETE')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface Delete { }
		
	}
	
}
