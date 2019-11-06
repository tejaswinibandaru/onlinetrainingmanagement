package com.cg.onlinetraining.exception;

public class OTMSException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 718076775347477405L;

	public OTMSException() {
	}

	public OTMSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OTMSException(String message, Throwable cause) {
		super(message, cause);
	}

	public OTMSException(String message) {
		super(message);
	}

	public OTMSException(Throwable cause) {
		super(cause);
	}
}
