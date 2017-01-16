package com.cookathon.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
		ArrayList<Comments> commentsList = new ArrayList<Comments>();
		HashMap<String,Comments> allCommentsForThisReceipe = doa.getAllCommentsForAReceipe(receipeId);
		Set<String> allCommentsKeySet = allCommentsForThisReceipe.keySet();
		Iterator<String> keySetItr = allCommentsKeySet.iterator();
		while(keySetItr.hasNext()){
			commentsList.add(allCommentsForThisReceipe.get(keySetItr.next()));
		}
		return commentsList;
	}
	
	public void deleteComment(int commentId) throws Exception{
		doa.deleteComment(commentId);
	}

}
