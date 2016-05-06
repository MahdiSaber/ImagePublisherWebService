package swc.oosc.swcarchitect.webservice.exceptions;

//Developed by Mahdi Saber
//mahdi.saber@rwth-aachen.de

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import swc.oosc.swcarchitect.webservice.domain.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exp) {
		
		ErrorMessage errorMessage = new ErrorMessage(exp.getMessage(),404,"mahdi.saber@rwth-aachen.de");  
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}



}