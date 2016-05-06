package swc.oosc.swcarchitect.webservice.database;

//Developed by Mahdi Saber
//mahdi.saber@rwth-aachen.de

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import swc.oosc.swcarchitect.webservice.domain.Image;

public class DatabaseSimulator {
	
	private static List<Image> data = new ArrayList<>();

	public static List<Image> getData() {
		return data;
	}
	
//    static{
//    	try{
//		data.add(new Image("Image", new URL("http://lorempixel.com/400/200/sports/"),true));
//        data.add(new Image("Image", new URL("http://lorempixel.com/1280/1024/sports/"),true));
//        data.add(new Image("Image", new URL("http://lorempixel.com/500/500/sports/"),true));
//        data.add(new Image("Image", new URL("http://lorempixel.com/640/480/sports/"),false));
//        data.add(new Image("Image", new URL("http://lorempixel.com/800/600/sports/"),false));
//    	}
//    	catch(Exception e){e.printStackTrace();}
//	}
	
	

}
