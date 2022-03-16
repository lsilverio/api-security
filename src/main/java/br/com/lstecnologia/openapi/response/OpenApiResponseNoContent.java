package br.com.lstecnologia.openapi.response;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Inherited
	@ApiResponses(value = {
	    @ApiResponse(
	            code = 204, 
	            message = "Request was successful and the json informed in the body was updated on the server."),
	    @ApiResponse(
	            code = 400, 
	            message = "The server did not understand the request because it has an invalid syntax."),    
	    @ApiResponse(
	            code = 401, 
	            message = "The client must authenticate itself to get the requested response."),
	    @ApiResponse(
	            code = 403, 
	            message = "You do not have permission to perform this operation"),
	    @ApiResponse(
	            code = 404, 
	            message = "Resource Not Found. O servidor não pode encontrar o recurso solicitado."),
	    @ApiResponse(
	            code = 500, 
	            message = "Internal Server Error. O servidor encontrou uma situação com a qual não sabe lidar.")  
	    }
	)
	public @interface OpenApiResponseNoContent {

	}