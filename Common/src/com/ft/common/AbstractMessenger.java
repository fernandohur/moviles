package com.ft.common;


public abstract class AbstractMessenger implements MessageReceiver{

	protected MessageSender sender;
	
	public AbstractMessenger(MessageSender sender) {
		this.sender = sender;
	}
}
