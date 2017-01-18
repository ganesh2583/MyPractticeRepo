package com.cookathon.model;

/**
 * 
 * This is a bean class to represent Comments for an recipe
 * 
 * @author Ganesh
 *
 */
public class Comments {
	
	private int commentId;
	private String author;
	private String commentMessage;
	private int receipeId;
	
	public Comments(){
		
	}
	
	
	/**
	 * @param commentId
	 * @param author
	 * @param commentMessage
	 */
	public Comments(int commentId, String author, String commentMessage,int receipeId) {
		this.commentId = commentId;
		this.author = author;
		this.commentMessage = commentMessage;
		this.receipeId = receipeId;
	}


	/**
	 * @return the commentId
	 */
	public int getCommentId() {
		return commentId;
	}
	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the commentMessage
	 */
	public String getCommentMessage() {
		return commentMessage;
	}
	/**
	 * @param commentMessage the commentMessage to set
	 */
	public void setCommentMessage(String commentMessage) {
		this.commentMessage = commentMessage;
	}


	/**
	 * @return the receipeId
	 */
	public int getReceipeId() {
		return receipeId;
	}


	/**
	 * @param receipeId the receipeId to set
	 */
	public void setReceipeId(int receipeId) {
		this.receipeId = receipeId;
	}
	
	@Override
	public String toString() {
		String commentsString = "comment id : "+this.getCommentId()+ " comment author: "+this.getAuthor() + " comment message : "+this.getCommentMessage() + " comment receipe Id :"+this.getReceipeId();
		return commentsString;
	}
}
