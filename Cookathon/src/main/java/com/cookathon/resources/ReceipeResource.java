package com.cookathon.resources;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.cookathon.resources.beans.MessageFilterBeans;

@Path("/receipes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReceipeResource extends Application{

	@GET
	public void getAllReceipes(@BeanParam MessageFilterBeans messageFilterBeans){

	}
	
}
