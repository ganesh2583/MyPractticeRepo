package com.cookathon.dao;

import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;

import com.cookathon.database.DerbyConnector;
import com.cookathon.model.Comments;
import com.cookathon.model.Receipes;

public class DataBaseConnector {
	
	HashMap<String,Receipes> allReceiPes = new HashMap<>();
	
	public Receipes createReceipe(Receipes receipe) throws Exception{
		java.sql.Date sqlDate = new java.sql.Date(new Date().getTime()); 
		receipe.setCreatedDate(sqlDate);
		String addReceipeSQLString = "INSERT INTO RECEIPES(RECEIPE_AUTHOR, RECEIPE_TITLE, RECEIPE_DESCRIPTION, RECEIPE_INGREDIENTS, RECEIPE_PREPARATION, CREATED_DATE) VALUES(\'" + receipe.getAuthor()
				+ "\', \'" + receipe.getReceipeTitle() + "\', \'" + receipe.getReceipeDescription() + "\', \'" + receipe.getReceipeIngredients() + "\', \'"
				+ receipe.getReceipePreparation() + "\', \'" + receipe.getCreatedDate() + "\')";
		DerbyConnector.executeUpdate(addReceipeSQLString);
		return receipe;
	}
	
	public HashMap<String,Receipes> getAllReceipes() throws Exception{
		String getAllReceipes = "SELECT * from RECEIPES";
		ResultSet receipesResultSet = DerbyConnector.executeQuery(getAllReceipes);
		while(receipesResultSet.next()){
			Receipes receipesObj = new Receipes(receipesResultSet.getString("RECEIPE_AUTHOR"),
					receipesResultSet.getString("RECEIPE_TITLE"), receipesResultSet.getString("RECEIPE_DESCRIPTION"),
					receipesResultSet.getString("RECEIPE_INGREDIENTS"), receipesResultSet.getString("RECEIPE_PREPARATION"),
					null, null);
			allReceiPes.put(new Integer(receipesObj.getReceipeId()).toString(), receipesObj);
		}
		return allReceiPes;
	}
	
	public Receipes getReceipe(String receipeId) throws Exception{
		return getAllReceipes().get(receipeId);
	}
	
	public Receipes updateReceipe(Receipes receipe) throws Exception{
		String addReceipeSQLString = "UPDATE RECEIPES SET RECEIPE_AUTHOR = " + receipe.getAuthor()
		+ ", RECEIPE_TITLE=" + receipe.getReceipeTitle() + ", RECEIPE_DESCRIPTION=" + receipe.getReceipeDescription() + ", RECEIPE_INGREDIENTS =" + receipe.getReceipeIngredients() 
		+ ", RECEIPE_PREPARATION = "
		+ receipe.getReceipePreparation() + ", " + receipe.getCreatedDate() + " WHERE  RECEIPE_ID = "+ receipe.getReceipeId() ;
		DerbyConnector.executeUpdate(addReceipeSQLString);
		return getAllReceipes().get(receipe.getReceipeId());
	}
	
	public void deleteReceipe(int receipeId) throws Exception{
		String addReceipeSQLString = "DELETE FROM RECEIPES WHERE  RECEIPE_ID = "+ receipeId ;
		DerbyConnector.executeUpdate(addReceipeSQLString);
	}
	
	
	public void createComment(Comments comment) throws Exception {
		String addCommentSQLString = "INSERT INTO COMMENTS VALUES(" + comment.getCommentId() + "," + comment.getCommentMessage()
				+ "," + comment.getCommentMessage() + ")";
		DerbyConnector.executeUpdate(addCommentSQLString);
	}

}
