package swc.oosc.swcarchitect.webservice.messagebody;

//Developed by Mahdi Saber
//mahdi.saber@rwth-aachen.de

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.ArrayList;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

//import com.owlike.genson.Genson;
//import com.owlike.genson.GensonBuilder;

import swc.oosc.swcarchitect.webservice.domain.Image;
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ArrayListWriter implements MessageBodyWriter<ArrayList<Image>> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public long getSize(ArrayList<Image> t, Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public void writeTo(ArrayList<Image> t, Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
					throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		Gson gb = new GsonBuilder().registerTypeAdapter(Image.class, new ImageSerializer()).create();
		
		String json = gb.toJson(t);
		
		entityStream.write(json.toString().getBytes());
		
	}

}
