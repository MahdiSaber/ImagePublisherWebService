package swc.oosc.swcarchitect.webservice.messagebody;

//Developed by Mahdi Saber
//mahdi.saber@rwth-aachen.de

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import swc.oosc.swcarchitect.webservice.domain.Image;
import swc.oosc.swcarchitect.webservice.exceptions.WrongSendFromatException;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class ImageReader implements MessageBodyReader<Image>{

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Image readFrom(Class<Image> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
					throws IOException, WebApplicationException {
		
		JsonReader jsonReader = Json.createReader(entityStream);
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		entityStream.close();
		Image img;
		
		
		String ErrorStringCode="";
		String name = null;
		String location = null;
		boolean state = true;
		
		
		try
		{
			state = jsonObject.getBoolean("state");
		}
		catch(NullPointerException e)
		{
			ErrorStringCode = "state";
		}
		try
		{
			name = jsonObject.getString("name");
		}
		catch(NullPointerException e)
		{
			ErrorStringCode = "name";
		}
		try
		{
			location = jsonObject.getString("location");
		}
		catch(NullPointerException e)
		{
			ErrorStringCode = "location";
		}
		
		switch (ErrorStringCode) {
		case "":
			img = new Image(name, new URL(location), state);
			break;
			
		case "state":
			img = new Image(name, new URL(location), true);
			break;
			
		case "name":
		case "location":
			throw new WrongSendFromatException("You have not set the '" + ErrorStringCode + "' field properly!");
			
		default:
			throw new WrongSendFromatException("Your sending body has a problem!");
		}
		
		return img;
	}

}
