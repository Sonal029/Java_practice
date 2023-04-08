package com.court.Exception;

public class SomethingWentWrongException extends Exception 
{
	private String message;

	public SomethingWentWrongException(String message) {
		super(message);
	}

	

}
