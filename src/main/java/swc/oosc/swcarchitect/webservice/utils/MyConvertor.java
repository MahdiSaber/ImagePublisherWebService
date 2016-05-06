package swc.oosc.swcarchitect.webservice.utils;

//Developed by Mahdi Saber
//mahdi.saber@rwth-aachen.de

import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class MyConvertor {
	
	public static long time2Long(LocalDateTime time)
	{
		
		return time.toInstant(ZoneOffset.ofHours(0)).toEpochMilli();
	}
	
	public static String url2String(URL u)
	{
		String result = u.toString();
		result = u.toString().replace("file:/","file:////");
		return result;
	}

}
