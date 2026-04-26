package com.example.exception;

@SuppressWarnings("serial")
public class UserNumberException extends RuntimeException {
	
	private int userNumber;

	public UserNumberException(int userNumber) {
		this.userNumber = userNumber;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
}
