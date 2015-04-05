package com.github.marcelocure.sandbox.java.activemq.inboxconsumer;

import javax.jms.JMSException;

public class App {
	public static void main(String[] args) throws JMSException {
		InboxMessageConsumer inboxMessageConsumer = new InboxMessageConsumer();
		System.out.println("Reading queue");
		while (true) inboxMessageConsumer.readEmails();
	}
}