package com.github.marcelocure.sandbox.java.activemq.inboxproducer;


public class App {
	public static void main(String[] args) throws InterruptedException {
		InboxMessageProducer inboxMessageProducer = new InboxMessageProducer();
		System.out.println("Sending message to queue");
		MailInputMessageDao mailInputMessageDao = new MailInputMessageDao();
		
		for (MailInputMessage mailInputMessage : mailInputMessageDao.buildInputMessages()) {
			Thread.sleep(2000);
			inboxMessageProducer.produce(mailInputMessage);
		}
	}
}