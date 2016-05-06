package swc.oosc.swcarchitect.webservice.exceptions;

//Developed by Mahdi Saber
//mahdi.saber@rwth-aachen.de

public class WrongSendFromatException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6240456381636446236L;
	
	public WrongSendFromatException(String message)
	{
		super(message);
		
	}

}
