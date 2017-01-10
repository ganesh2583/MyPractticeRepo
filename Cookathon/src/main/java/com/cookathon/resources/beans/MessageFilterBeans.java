package com.cookathon.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBeans {
	
	private @QueryParam("pageOffset") int pageOffset;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;
	
	public int getPageOffset() {
		return pageOffset;
	}
	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	

}
