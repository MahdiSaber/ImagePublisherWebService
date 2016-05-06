package swc.oosc.swcarchitect.webservice.client;

//Developed by Mahdi Saber
//mahdi.saber@rwth-aachen.de

import java.net.URI;
import java.net.URL;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SendEntity {

	private String name;
    
    private URI location;
    
    private boolean state;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URI getLocation() {
		return location;
	}

	public void setLocation(URI location) {
		this.location = location;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
    
    
}
