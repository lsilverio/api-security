package br.com.lstecnologia.security;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public @interface UserSecurity {

	public @interface Permission {
		
		@PreAuthorize("hasAuthority('REGISTER_USERS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface Register { }
		
		@PreAuthorize("hasAuthority('EDIT_USERS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface Edit { }

		@PreAuthorize("hasAuthority('CONSULT_USERS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface Consult { }
		
		@PreAuthorize("hasAuthority('DELETE_USERS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface Delete { }
		
	}
	
}
