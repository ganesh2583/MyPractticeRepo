package com.cookathon.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cookathon.dao.DataBaseConnector;
import com.cookathon.model.Comments;

/**
 * This is a comment service class which 
 * interacts with the DB layer and get all the comments from the DB layer
 * 
 * @author Ganesh
 *
 */
public class CommentsService {
	
	DataBaseConnector doa = new DataBaseConnector();
	
	public Comments createComment(Comments comment) throws Exception{
		return doa.createComment(comment);
	}
	
	public List<Comments> getComments(int receipeId) throws Exception{
		HashMap<String,ArrayList<Comments>> allCommentsForThisReceipe = doa.getAllCommentsForAReceipe(receipeId);
		ArrayList commentsList = allCommentsForThisReceipe.get(new Integer(receipeId).toString());
		return commentsList;
	}
	
	public void deleteComment(int commentId) throws Exception{
		doa.deleteComment(commentId);
	}

}
