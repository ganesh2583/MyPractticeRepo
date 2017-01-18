package com.cookathon.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * This class is bean class to hold to represent a Recipe object
 * 
 * @author Ganesh
 *
 *
 */
public class Receipes {
	
	private int receipeId;
	private String author;
	private String receipeTitle;
	private String receipeDescription;
	private String receipeIngredients;
	private String receipePreparation;
	private String receipeImages;
	private Date createdDate;
	private ArrayList<Comments> comments;
	
	public Receipes(){
		
	}
	
	/**
	 * 
	 * Parameterized constructor used to create a Receipe Object
	 * 
	 * @param author
	 * @param receipeTitle
	 * @param receipeDescription
	 * @param receipeIngredients
	 * @param receipePreparation
	 * @param receipeImages
	 * @param comments
	 * 
	 *//*
	public Receipes(String author, String receipeTitle, String receipeDescription, String receipeIngredients,
			String receipePreparation, String receipeImages, ArrayList<Comments> comments) {
		this.author = author;
		this.receipeTitle = receipeTitle;
		this.receipeDescription = receipeDescription;
		this.receipeIngredients = receipeIngredients;
		this.receipePreparation = receipePreparation;
		this.receipeImages = receipeImages;
		this.createdDate = new Date();
		this.comments = comments;
	}*/
	
	/**
	 * 
	 * Parameterized constructor used to create a Receipe Object
	 * 
	 * @param author
	 * @param receipeTitle
	 * @param receipeDescription
	 * @param receipeIngredients
	 * @param receipePreparation
	 * @param receipeImages
	 * @param comments
	 * 
	 */
	public Receipes(int receipeId, String author, String receipeTitle, String receipeDescription, String receipeIngredients,
			String receipePreparation, String receipeImages, ArrayList<Comments> comments) {
		this.receipeId = receipeId;
		this.author = author;
		this.receipeTitle = receipeTitle;
		this.receipeDescription = receipeDescription;
		this.receipeIngredients = receipeIngredients;
		this.receipePreparation = receipePreparation;
		this.receipeImages = receipeImages;
		this.createdDate = new Date();
		this.comments = comments;
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
	 * @return the receipeTitle
	 */
	public String getReceipeTitle() {
		return receipeTitle;
	}
	/**
	 * @param receipeTitle the receipeTitle to set
	 */
	public void setReceipeTitle(String receipeTitle) {
		this.receipeTitle = receipeTitle;
	}
	/**
	 * @return the receipeDescription
	 */
	public String getReceipeDescription() {
		return receipeDescription;
	}
	/**
	 * @param receipeDescription the receipeDescription to set
	 */
	public void setReceipeDescription(String receipeDescription) {
		this.receipeDescription = receipeDescription;
	}
	/**
	 * @return the receipeIngredients
	 */
	public String getReceipeIngredients() {
		return receipeIngredients;
	}
	/**
	 * @param receipeIngredients the receipeIngredients to set
	 */
	public void setReceipeIngredients(String receipeIngredients) {
		this.receipeIngredients = receipeIngredients;
	}
	/**
	 * @return the receipePreparation
	 */
	public String getReceipePreparation() {
		return receipePreparation;
	}
	/**
	 * @param receipePreparation the receipePreparation to set
	 */
	public void setReceipePreparation(String receipePreparation) {
		this.receipePreparation = receipePreparation;
	}
	/**
	 * @return the receipeImages
	 */
	public String getReceipeImages() {
		return receipeImages;
	}
	/**
	 * @param receipeImages the receipeImages to set
	 */
	public void setReceipeImages(String receipeImages) {
		this.receipeImages = receipeImages;
	}
	/**
	 * @return the comments
	 */
	public ArrayList<Comments> getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(ArrayList<Comments> comments) {
		this.comments = comments;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	public String toString() {
		String receipeString = "Receipe obj: id = "+this.getReceipeId() +
		" author : "+this.getAuthor() +
		" comments : "+this.getComments() +
		" date of creation : "+this.getCreatedDate() +
		" description : "+this.getReceipeDescription() +
		" images : "+this.getReceipeImages() +
		" ingredients : "+this.getReceipeIngredients() +
		" preparation : "+this.getReceipePreparation() +
		" title : "+this.getReceipeTitle();
		return receipeString;
	}

}
 