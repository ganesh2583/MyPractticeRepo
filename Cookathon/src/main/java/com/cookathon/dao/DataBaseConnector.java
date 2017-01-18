package com.cookathon.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.cookathon.database.DerbyConnector;
import com.cookathon.model.Comments;
import com.cookathon.model.Receipes;

public class DataBaseConnector {
	
	public Receipes createReceipe(Receipes receipe) throws Exception{
		java.sql.Date sqlDate = new java.sql.Date(new Date().getTime()); 
		receipe.setCreatedDate(sqlDate);
		String addReceipeSQLString = "INSERT INTO RECEIPES(RECEIPE_AUTHOR, RECEIPE_TITLE, RECEIPE_DESCRIPTION, RECEIPE_INGREDIENTS, RECEIPE_PREPARATION, CREATED_DATE)"
				+ " VALUES(\'" + receipe.getAuthor()
				+ "\', \'" + receipe.getReceipeTitle() + "\', \'" + receipe.getReceipeDescription() + "\', \'" + receipe.getReceipeIngredients() + "\', \'"
				+ receipe.getReceipePreparation() + "\', \'" + receipe.getCreatedDate() + "\')";
		DerbyConnector.executeUpdate(addReceipeSQLString);
		String getThisCreatedReceipe = "SELECT * from RECEIPES WHERE RECEIPE_AUTHOR = \'"+receipe.getAuthor() + "\' AND CREATED_DATE = \'"+receipe.getCreatedDate() + "\'";
		System.out.println("Get query is "+getThisCreatedReceipe);
		ResultSet createdReceipeResult = DerbyConnector.executeQuery(getThisCreatedReceipe);
		while(createdReceipeResult.next()){
			receipe.setReceipeId(createdReceipeResult.getInt("RECEIPE_ID"));
		}
		return receipe;
	}
	
	public HashMap<String,Receipes> getAllReceipes() throws Exception{
		HashMap<String,Receipes> allReceiPes = new HashMap<>();
		String getAllReceipes = "SELECT * from RECEIPES";
		//String getAllReceipes = "SELECT * from RECEIPES JOIN COMMENTS ON RECEIPES.RECEIPE_ID = COMMENTS.RECEIPE_ID";
		ResultSet receipesResultSet = DerbyConnector.executeQuery(getAllReceipes);
		while(receipesResultSet.next()){
			Receipes receipesObj = new Receipes(receipesResultSet.getInt("RECEIPE_ID"),receipesResultSet.getString("RECEIPE_AUTHOR"),
					receipesResultSet.getString("RECEIPE_TITLE"), receipesResultSet.getString("RECEIPE_DESCRIPTION"),
					receipesResultSet.getString("RECEIPE_INGREDIENTS"), receipesResultSet.getString("RECEIPE_PREPARATION"),
					null, null);
			HashMap<String, ArrayList<Comments>> commentForThisReceipe = getAllCommentsForAReceipe(receipesResultSet.getInt("RECEIPE_ID"));
			ArrayList<Comments> commentsList = commentForThisReceipe.get(new Integer(receipesResultSet.getInt("RECEIPE_ID")).toString());
			receipesObj.setComments(commentsList);
			System.out.println("Receipe Obj is "+receipesObj);
			allReceiPes.put(new Integer(receipesObj.getReceipeId()).toString(), receipesObj);
		}
		return allReceiPes;
	}
	
	public Receipes getReceipe(String receipeId) throws Exception{
		return getAllReceipes().get(receipeId);
	}
	
	public Receipes updateReceipe(Receipes receipe) throws Exception{
		String addReceipeSQLString = "UPDATE RECEIPES SET RECEIPE_AUTHOR = \'" + receipe.getAuthor()
		+ "\', RECEIPE_TITLE=\'" + receipe.getReceipeTitle() + "\', RECEIPE_DESCRIPTION=\'" + receipe.getReceipeDescription() + "\', "
				+ "RECEIPE_INGREDIENTS =\'" + receipe.getReceipeIngredients() 
		+ "\', RECEIPE_PREPARATION = \'"
		+ receipe.getReceipePreparation() + "\' WHERE  RECEIPE_ID = "+ receipe.getReceipeId() ;
		DerbyConnector.executeUpdate(addReceipeSQLString);
		return getAllReceipes().get(new Integer(receipe.getReceipeId()).toString());
	}
	
	public void deleteReceipe(int receipeId) throws Exception{
		String deleteCommentsForReceipe = "DELETE FROM COMMENTS WHERE RECEIPE_ID = "+receipeId;
		String deleteReceipeQuery = "DELETE FROM RECEIPES WHERE  RECEIPE_ID = "+ receipeId ;
		DerbyConnector.executeUpdate(deleteCommentsForReceipe);
		DerbyConnector.executeUpdate(deleteReceipeQuery);
	}
	
	
	public Comments createComment(Comments comment) throws Exception {
		String addCommentSQLString = "INSERT INTO COMMENTS(COMMENT_MESSAGE,COMMENT_AUTHOR,RECEIPE_ID) VALUES(\'"+ comment.getCommentMessage()
				+ "\',\'" + comment.getAuthor() + "\'," + comment.getReceipeId() + ")";
		DerbyConnector.executeUpdate(addCommentSQLString);
		String getCreatedComment = "SELECT * from COMMENTS WHERE COMMENT_MESSAGE = \'"+comment.getCommentMessage() + "\'";
		System.out.println("Get query is "+getCreatedComment);
		ResultSet createdReceipeResult = DerbyConnector.executeQuery(getCreatedComment);
		while(createdReceipeResult.next()){
			comment.setReceipeId(createdReceipeResult.getInt("COMMENT_ID"));
		}
		return comment;
	}
	
	public void deleteComment(int commentId) throws Exception{
		String addCommentSQLString = "DELETE FROM COMMENTS WHERE  COMMENT_ID = " + commentId ;
		DerbyConnector.executeUpdate(addCommentSQLString);
	}
	
	public HashMap<String, ArrayList<Comments>> getAllCommentsForAReceipe(int receipeId) throws Exception{
		String getAllCommentsForAReceipeId = "SELECT * from COMMENTS WHERE RECEIPE_ID = " + receipeId  ;
		ResultSet commentsResultSet = DerbyConnector.executeQuery(getAllCommentsForAReceipeId);
		ArrayList<Comments> commentsList = new ArrayList<Comments>();
		HashMap<String,ArrayList<Comments>> allCommentsForAReceipeMap = new HashMap<String,ArrayList<Comments>>();
		while(commentsResultSet.next()){
			Comments commentsObj = new Comments(commentsResultSet.getInt("COMMENT_ID"), commentsResultSet.getString("COMMENT_MESSAGE"), commentsResultSet.getString("COMMENT_AUTHOR"), commentsResultSet.getInt("RECEIPE_ID"));
			System.out.println(commentsObj);
			commentsList.add(commentsObj);
		}
		allCommentsForAReceipeMap.put(new Integer(receipeId).toString(), commentsList);
		return allCommentsForAReceipeMap;
	}

}
