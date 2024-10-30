package com.ox.exceptions;

public class OpponentPositionException extends RuntimeException
{
	public OpponentPositionException()
	{
		super();
	}
	
	public OpponentPositionException(String message)
	{
		super(message);
	}
}