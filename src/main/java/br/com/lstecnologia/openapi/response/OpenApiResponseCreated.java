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
	            code = 201, 
	            message = "The request was successful and a new resource was created as a result."),
	    @ApiResponse(
	            code = 400, 
	            message = "The server did not understand the request because it has an invalid syntax."),    
	    @ApiResponse(
	            code = 401, 
	            message = "The client must authenticate itself to get the requested response."),
	    @ApiResponse(
	            code = 403, 
	            message = "You do not have permission to perform this operation."),
	    @ApiResponse(
	            code = 404, 
	            message = "The server cannot find the requested resource."),
	    @ApiResponse(
	            code = 500, 
	            message = "The server has encountered a situation it doesn't know how to handle.")  
	    }	
	)
	public @interface OpenApiResponseCreated {

	}