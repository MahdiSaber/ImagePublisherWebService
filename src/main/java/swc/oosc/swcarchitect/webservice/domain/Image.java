package swc.oosc.swcarchitect.webservice.domain;

//Developed by Mahdi Saber
//mahdi.saber@rwth-aachen.de

import java.net.URL;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Image {
	
	private long id;
	
	private String name;
    
    private URL location;
    
    private LocalDateTime publishedAt;
    
    private LocalDateTime lastModified;
    
    private boolean state;
   
    public Image(String name, URL location, boolean state) {
        this.name = name;
        this.location = location;
        this.state = state;
        this.publishedAt = LocalDateTime.now();
        this.lastModified = LocalDateTime.now();

    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URL getLocation() {
		return location;
	}

	public void setLocation(URL location) {
		this.location = location;
	}



	public LocalDateTime getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(LocalDateTime publishedAt) {
		this.publishedAt = publishedAt;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}
    
}
