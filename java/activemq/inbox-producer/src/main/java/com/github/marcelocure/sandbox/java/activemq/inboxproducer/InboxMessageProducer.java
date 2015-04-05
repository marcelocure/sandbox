package com.github.marcelocure.sandbox.java.activemq.inboxproducer;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import com.github.marcelocure.sandbox.java.activemq.inboxcommons.MailMessage;

public class InboxMessageProducer {
	public void produce(MailMessage mailMessage) {

		try {
			Connection connection = Connector.getConnection();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("mailbox");
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			ObjectMessage message = session.createObjectMessage(mailMessage);
			producer.send(message);
			session.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}