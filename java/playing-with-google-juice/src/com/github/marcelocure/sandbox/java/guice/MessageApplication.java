package com.github.marcelocure.sandbox.java.guice;

import com.google.inject.Inject;

public class MessageApplication {

	private MessageService service;

	@Inject
	public MessageApplication(MessageService service) {
		this.service = service;
	}

	public void setService(MessageService service) {
		this.service = service;
	}

	public boolean sendMessage(String message, String recipient) {
		return service.sendMessage(message, recipient);
	}
}