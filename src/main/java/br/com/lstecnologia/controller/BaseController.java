package br.com.lstecnologia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class BaseController {
	
	public ResponseEntity<Object> ok(Object object) {
		return ResponseEntity.ok().body(object);
	}
	
	public ResponseEntity<Void> noContent() {
		return ResponseEntity.noContent().build();
	}

	public ResponseEntity<Object> created(Object object, Long id) {
		return ResponseEntity
				.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri())
				.body(object);
	}

}
