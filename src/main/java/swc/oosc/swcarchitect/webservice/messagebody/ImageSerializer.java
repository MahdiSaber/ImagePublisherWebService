package swc.oosc.swcarchitect.webservice.messagebody;

//Developed by Mahdi Saber
//mahdi.saber@rwth-aachen.de

import java.lang.reflect.Type;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import swc.oosc.swcarchitect.webservice.domain.Image;
import swc.oosc.swcarchitect.webservice.domain.ImageLink;
import swc.oosc.swcarchitect.webservice.utils.MyConvertor;

public class ImageSerializer implements JsonSerializer {

	@Override
	public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
	
		Image img = (Image)src;
		final JsonObject jsonObject = new JsonObject();

		
		Long id = img.getId();
		String name = img.getName();
		URL url = img.getLocation();
		LocalDateTime pa = img.getPublishedAt();
		LocalDateTime lm = img.getLastModified();
		boolean state = img.isState();
		
		jsonObject.addProperty("id", id);
		jsonObject.addProperty("name", name);
		jsonObject.addProperty("location", MyConvertor.url2String(url));
		jsonObject.addProperty("publishedAt", MyConvertor.time2Long(pa));
		jsonObject.addProperty("lastModified", MyConvertor.time2Long(lm));
		jsonObject.addProperty("state", state);
		
		return jsonObject;
	}
	

	
	
	

}
