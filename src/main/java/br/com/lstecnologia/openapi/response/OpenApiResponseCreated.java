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
	            message = "Created. A requisição foi bem sucessida e um novo recurso foi criado como resultado.\r\n" + 
	            		"Esta é uma tipica resposta enviada após uma requisição POST."),
	    @ApiResponse(
	            code = 400, 
	            message = "Bad Request. Essa resposta significa que o servidor não entendeu a requisição pois está com\r\n" + 
	            		"uma sintaxe inválida. Algum parametro enviado não está de acordo com o que a API espera."),    
	    @ApiResponse(
	            code = 401, 
	            message = "Unauthorized. Embora o padrão HTTP especifique \"unauthorized\", semanticamente, essa resposta significa\r\n" + 
	            		"\"unauthenticated\". Ou seja, o cliente deve se autenticar para obter a resposta solicitada."),
	    @ApiResponse(
	            code = 403, 
	            message = "Forbidden. Na API geralmente ocorre devido o não envio do Token ou envio de algum\r\n" + 
	            		"Token inválido no header da request."),
	    @ApiResponse(
	            code = 404, 
	            message = "Resource Not Found. O servidor não pode encontrar o recurso solicitado."),
	    @ApiResponse(
	            code = 500, 
	            message = "Internal Server Error. O servidor encontrou uma situação com a qual não sabe lidar.")   
	    }
	)
	public @interface OpenApiResponseCreated {

	}