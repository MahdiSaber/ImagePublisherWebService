package swc.oosc.swcarchitect.webservice.service;

//Developed by Mahdi Saber
//mahdi.saber@rwth-aachen.de

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import swc.oosc.swcarchitect.webservice.database.DatabaseSimulator;
import swc.oosc.swcarchitect.webservice.domain.Image;
import swc.oosc.swcarchitect.webservice.exceptions.DataNotFoundException;

public class ImageService {
	
	private List<Image> data = DatabaseSimulator.getData();
	
	public ImageService() {
		try{
		addImage(new Image("Image", new URL("http://lorempixel.com/400/200/sports/"),true));
		addImage(new Image("Image", new URL("http://lorempixel.com/1280/1024/sports/"),true));
		addImage(new Image("Image", new URL("http://lorempixel.com/500/500/sports/"),true));
		addImage(new Image("Image", new URL("http://lorempixel.com/640/480/sports/"),true));
		addImage(new Image("Image", new URL("http://lorempixel.com/800/600/sports/"),true));
		}
		catch(MalformedURLException exception)
		{
			exception.printStackTrace();
		}
	}
	
	public List<Image> getAllImages(){
		ArrayList<Image> result = new ArrayList<>();
		
		for(Image img : data)
		{
			if (img.isState()) {
				result.add(img);
			}
		}
		return result;
	}
	
	public Image changeImage(long id, boolean state)
	{
		for(Image img : data)
		{
			if (img.getId() == id)
			{
				img.setState(state);
				return img;
			}
		}
		return null;
	}
	
	public Image addImage(Image image)
	{
		
		image.setId(data.size());
		data.add(image);
		return data.get(data.size()-1);
	}
	
	public Image getImage(long id)
	{
		Image img;
		try{
			img = data.get((int)id);
		}
		catch(IndexOutOfBoundsException exp){
			throw new DataNotFoundException("Message with id "+id+ " is not found!");		
		}
		return img;
	}
	
	
	

}
