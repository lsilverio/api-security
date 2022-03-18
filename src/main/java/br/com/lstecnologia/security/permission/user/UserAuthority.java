package br.com.lstecnologia.security.permission.user;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public @interface UserAuthority {

	public @interface Permission {
		
		@PreAuthorize("hasAuthority('USER_CONSULT_ALL')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface ConsultAll { }
		
		@PreAuthorize("hasAuthority('USER_CONSULT_ALL_BY_ID')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface ConsultAllById { }
		
		@PreAuthorize("hasAuthority('USER_CONSULT_BY_ID')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface ConsultById { }
		
		@PreAuthorize("hasAuthority('USER_UPDATE')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface Update { }

		@PreAuthorize("hasAuthority('USER_DELETE')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface Delete { }
		
		@PreAuthorize("hasAuthority('USER_ADD_PROFILE')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface AddProfile { }
		
		@PreAuthorize("hasAuthority('USER_REMOVE_PROFILE')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface RemoveProfile { }
		
	}
	
}
