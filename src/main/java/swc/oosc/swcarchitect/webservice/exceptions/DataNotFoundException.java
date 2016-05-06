package swc.oosc.swcarchitect.webservice.exceptions;

//Developed by Mahdi Saber
//mahdi.saber@rwth-aachen.de

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5877130626283994111L;

	public DataNotFoundException(String message){
		super(message);
	}
}
