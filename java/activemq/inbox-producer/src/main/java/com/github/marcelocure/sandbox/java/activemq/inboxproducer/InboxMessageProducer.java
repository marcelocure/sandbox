package com.github.marcelocure.sandbox.java.activemq.inboxproducer;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import com.github.marcelocure.sandbox.java.activemq.inboxproducer.connect.Connector;

public class InboxMessageProducer {
	public void produce(MailInputMessage mailInputMessage) {

		try {
			Connection connection = Connector.getConnection();
			connection.start();
			Session session = getSession(connection);
			Destination destination = session.createQueue(mailInputMessage.getQueue());
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			ObjectMessage message = session.createObjectMessage(mailInputMessage);
			producer.send(message);
			session.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Session getSession(Connection connection) throws JMSException {
		return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	}
}