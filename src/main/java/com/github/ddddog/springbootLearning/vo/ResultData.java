package com.github.ddddog.springbootLearning.vo;

import java.io.Serializable;

public class ResultData implements Serializable{
	
	String message;

	@Override
	public String toString() {
		return "ResultData{" +
				"message='" + message + '\'' +
				", firstMessage='" + firstMessage + '\'' +
				'}';
	}

	public String getFirstMessage() {
		return firstMessage;
	}

	public void setFirstMessage(String firstMessage) {
		this.firstMessage = firstMessage;
	}

	String firstMessage;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResultData(String message){
		this.message = message;
	}
	
	public ResultData(){
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
