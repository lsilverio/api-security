package br.com.lstecnologia.security.permission.profile;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public @interface ProfileSecurity {

	public @interface Permission {
		
		@PreAuthorize("hasAuthority('CONSULT_ALL_PROFILES')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface ConsultAll { }
		
		@PreAuthorize("hasAuthority('CONSULT_BY_ID_USER')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface ConsultById { }
		
		@PreAuthorize("hasAuthority('CONSULT_ALL_BY_ID_PROFILES')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface ConsultAllById { }
		
		@PreAuthorize("hasAuthority('UPDATE_USER')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface Update { }

		@PreAuthorize("hasAuthority('DELETE_USER')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface Delete { }
		
	}
	
}
