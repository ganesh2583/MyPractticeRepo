package com.cookathon.resources;

import java.util.ArrayList;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.cookathon.model.Receipes;
import com.cookathon.resources.beans.MessageFilterBeans;
import com.cookathon.services.ReceipeService;

@Path("/receipes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReceipeResource extends Application {
	
	ReceipeService receipeService = new ReceipeService();

	@GET
	public Response getAllReceipes(@BeanParam MessageFilterBeans messageFilterBeans) throws Exception{
		ArrayList receipesList =null;
		if(messageFilterBeans.getSize() != 0){
			for(int i=0;i<messageFilterBeans.getSize();i++){
				receipesList = new ArrayList();
				receipesList.add(receipeService.getAllReceipes().get(i));
			}
			return Response.ok(receipesList, MediaType.APPLICATION_JSON).build();
		}
		return Response.ok(receipeService.getAllReceipes()).build();
	}
	
	@GET
	@Path("/{receipeId}")
	public Response getReceipe(@PathParam("receipeId") int receipeId,@Context UriInfo uriInfo) throws Exception{
		String absuolutePath = uriInfo.getAbsolutePath().getPath();
		Receipes reciepeItem = receipeService.getAllReceipesMap().get(new Integer(receipeId).toString());
		reciepeItem.addLinks(absuolutePath, "self");
		return Response.ok(reciepeItem).build();
	}
	
	@POST
	public Response createReceipe(Receipes receipe,@Context UriInfo uriInfo) throws Exception{
		String absuolutePath = uriInfo.getAbsolutePath().getPath();
		Receipes createReceipe = receipeService.createReceipe(receipe);
		createReceipe.addLinks(absuolutePath, "self");
		return Response.created(uriInfo.getAbsolutePath()).entity(createReceipe).build();
	}
	
	@PUT
	@Path("/{receipeId}")
	public Response updateReceipe(Receipes receipe,@Context UriInfo uriInfo) throws Exception{
		String absuolutePath = uriInfo.getAbsolutePath().getPath();
		Receipes updatedReceipe = receipeService.updateReceipe(receipe);
		updatedReceipe.addLinks(absuolutePath, "self");
		return Response.accepted(updatedReceipe).build();
	}
	
	@DELETE
	@Path("/{receipeId}")
	public Response deleteReceipe(@PathParam("receipeId") int receipeId) throws Exception{
		receipeService.deleteReceie(receipeId);
		return Response.ok().build();
		
	}
	
	
	@Path("/{receipeId}/comments")
	public CommentsResource getComments(){
		return new CommentsResource();
	}
	
}
