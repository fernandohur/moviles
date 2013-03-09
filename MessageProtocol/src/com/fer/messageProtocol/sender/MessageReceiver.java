package com.fer.messageProtocol.sender;

public interface MessageReceiver {

	public void onMessageReceived(String sender, String message);
	
}
