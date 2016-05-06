package swc.oosc.swcarchitect.webservice.rest;

//Developed by Mahdi Saber
//mahdi.saber@rwth-aachen.de

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import swc.oosc.swcarchitect.webservice.domain.Image;
import swc.oosc.swcarchitect.webservice.service.ImageService;

@Path("/image")
public class ImageResource {
	
	static ImageService imageService = new ImageService();
	
	@GET
	@Path("/info")
	@Produces(MediaType.TEXT_PLAIN)
	public String info() {

        return "Everything fine";
    }
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Image> getAllImages()
	{

		return imageService.getAllImages();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Image addImage(Image image){
		
		return imageService.addImage(image);
	}
	
	@GET
	@Path("{imageid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Image getImage(@PathParam("imageid") long i, @Context UriInfo uriInfo){
		
		Image img = imageService.getImage(i);
		
		return img;
	}
	
	@PUT
	@Path("{imageid}/{state}")
	@Produces(MediaType.APPLICATION_JSON)
	public Image ModifyImage(@PathParam("imageid") long id,@PathParam("state") boolean state)
	{
		return imageService.changeImage(id, state);
	}

	private String getUriForSelf(UriInfo uriInfo, Image img) {
		String uri = uriInfo.getBaseUriBuilder().path(ImageResource.class)
		.path(Long.toString(img.getId())).build().toString();
		return uri;
	}
	
	private String getUriForAll(UriInfo uriInfo, Image img) {
		String uri = uriInfo.getBaseUriBuilder().path(ImageResource.class)
		.build().toString();
		return uri;
	}
	
	
 
}
