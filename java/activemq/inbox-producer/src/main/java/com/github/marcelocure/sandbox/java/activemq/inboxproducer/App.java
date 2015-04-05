package com.github.marcelocure.sandbox.java.activemq.inboxproducer;

import com.github.marcelocure.sandbox.java.activemq.inboxcommons.MailMessage;
public class App {
	public static void main(String[] args) {
		InboxMessageProducer inboxMessageProducer = new InboxMessageProducer();
		System.out.println("Sending message to queue");
		for (int i = 0 ; i <= 10 ; i++) {
			inboxMessageProducer.produce(new MailMessage("marcelo", "kari", "feliz aniversario", "coisa linda"));
		}
	}
}