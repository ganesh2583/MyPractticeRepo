package com.cookathon.model;

import java.util.concurrent.atomic.AtomicInteger;

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
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(0);
	
	public Comments(){
		
	}
	
	
	/**
	 * @param commentId
	 * @param author
	 * @param commentMessage
	 */
	public Comments(int commentId, String author, String commentMessage) {
		this.commentId = ID_GENERATOR.getAndIncrement();
		this.author = author;
		this.commentMessage = commentMessage;
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
	

}
