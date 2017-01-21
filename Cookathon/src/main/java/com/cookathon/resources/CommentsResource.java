package com.cookathon.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.cookathon.model.Comments;
import com.cookathon.services.CommentsService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentsResource extends Application{
	
	CommentsService commentsService = new CommentsService();
	
	@GET
	public Response getAllComments(@PathParam("receipeId") int receipeId) throws Exception{
		return Response.ok(commentsService.getComments(receipeId)).build();
	}
	
	
	@POST
	public Response addComment(@PathParam("receipeId") int receipeId, Comments comment,@Context UriInfo uriInfo) throws Exception {
		comment.setReceipeId(receipeId);
		String absoluteURL = uriInfo.getAbsolutePath().toString();
		comment.addLinks(absoluteURL, "self");
		return Response.ok(commentsService.createComment(comment)).build();
	}
	
	
	@DELETE
	@Path("/{commentId}")
	public Response deleteComment(@PathParam("commentId") int commentId) throws Exception{
		commentsService.deleteComment(commentId);
		return Response.accepted().build();
	}

}
