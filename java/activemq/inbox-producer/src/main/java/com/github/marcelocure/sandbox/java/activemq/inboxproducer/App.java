package com.github.marcelocure.sandbox.java.activemq.inboxproducer;

import com.github.marcelocure.sandbox.java.activemq.inboxcommons.MailMessage;

public class App {
	public static void main(String[] args) {
		InboxMessageProducer inboxMessageProducer = new InboxMessageProducer();
		System.out.println("Sending message to queue");
		MailInputMessageBuilder mailInputMessageBuilder = new MailInputMessageBuilder();
		MailInputMessage mailInputMessage = mailInputMessageBuilder.buildQueue("inbox").buildUserName("mcure").buildMessage(new MailMessage("mcure","kzenki", "luv ya", "I fucking love you")).build();
		inboxMessageProducer.produce(mailInputMessage);
	}
}