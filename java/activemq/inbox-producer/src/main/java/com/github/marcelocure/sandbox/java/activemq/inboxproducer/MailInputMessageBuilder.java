package com.github.marcelocure.sandbox.java.activemq.inboxproducer;

import com.github.marcelocure.sandbox.java.activemq.inboxcommons.MailMessage;


public class MailInputMessageBuilder {
	private MailInputMessage mailInputMessage;
	
	public MailInputMessageBuilder() {
		mailInputMessage = new MailInputMessage();
	}
	
	public MailInputMessageBuilder buildQueue(String queue) {
		mailInputMessage.setQueue(queue);
		return this;
	}
	
	public MailInputMessageBuilder buildMessage(MailMessage mailMessage) {
		mailInputMessage.setMessage(mailMessage);
		return this;
	}
	
	public MailInputMessageBuilder buildUserName(String userName) {
		mailInputMessage.setUserName(userName);
		return this;
	}
	
	public MailInputMessage build() {
		return mailInputMessage;
	}
}