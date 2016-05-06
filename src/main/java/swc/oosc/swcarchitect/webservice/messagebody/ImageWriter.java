package swc.oosc.swcarchitect.webservice.messagebody;

//Developed by Mahdi Saber
//mahdi.saber@rwth-aachen.de

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javassist.bytecode.CodeIterator.Gap;

import javax.json.Json;
import javax.json.JsonObject;


import swc.oosc.swcarchitect.webservice.domain.Image;
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ImageWriter implements MessageBodyWriter<Image> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public long getSize(Image t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public void writeTo(Image t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
					throws IOException, WebApplicationException {
		// TODO Auto-generated method stub

//### After adding ImageSerializer, the following codes are useless, since they are duplicate! 
		
//		//We have decided to deal with LocalDateTime as Long
//		// because it is very common in web services to deal with time as long.
//		LocalDateTime publishedAt = t.getPublishedAt();
//		Instant publishedAtInstant = publishedAt.toInstant(ZoneOffset.ofHours(0));
//		long publishedAtLong = publishedAtInstant.toEpochMilli();
//		
//		//We have decided to deal with LocalDateTime as Long
//		// because it is very common in web services to deal with time as long.
//		LocalDateTime lastModified = t.getLastModified();
//		Instant lastModifiedInstant = lastModified.toInstant(ZoneOffset.ofHours(0));
//		long lastModifiedLong = lastModifiedInstant.toEpochMilli();
//
//		
//		JsonObject jsonObject = Json.createObjectBuilder().add("name", t.getName())
//									.add("location", t.getLocation().toString())
//									.add("publishedAt", publishedAtLong)
//									.add("lastModified",lastModifiedLong)
//									.add("state",t.isState())
//									.build();
		
		Gson gb = new GsonBuilder().registerTypeAdapter(Image.class, new ImageSerializer()).create();
		String jsonObj = gb.toJson(t);
		
		entityStream.write(jsonObj.toString().getBytes());}
		
}
