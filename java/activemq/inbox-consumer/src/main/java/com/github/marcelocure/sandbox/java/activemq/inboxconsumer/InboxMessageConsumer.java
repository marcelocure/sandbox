package com.github.marcelocure.sandbox.java.activemq.inboxconsumer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import com.github.marcelocure.sandbox.java.activemq.inboxcommons.MailMessage;

public class InboxMessageConsumer implements ExceptionListener {
	
	
	public InboxMessageConsumer() {
	}
	
    public void readEmails() throws JMSException {
        	Connection connection = Connector.getConnection();
            connection.start();

            connection.setExceptionListener(this);

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("mailbox");

            MessageConsumer consumer = session.createConsumer(destination);

            MailMessage mailMessage = readMessage(consumer);
            System.out.println(mailMessage);

            consumer.close();
            session.close();
            connection.close();
    }

	private MailMessage readMessage(MessageConsumer consumer) throws JMSException {
		ObjectMessage message = (ObjectMessage) consumer.receive(3000);
		MailMessage mailMessage = null;
		if (message != null) mailMessage = (MailMessage) message.getObject();
		return mailMessage;
	}

	public void onException(JMSException e) {
		e.printStackTrace();
	}
}