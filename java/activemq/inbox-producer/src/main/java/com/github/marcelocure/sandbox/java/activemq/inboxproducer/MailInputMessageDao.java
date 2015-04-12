package com.github.marcelocure.sandbox.java.activemq.inboxproducer;

import java.util.ArrayList;
import java.util.List;

import com.github.marcelocure.sandbox.java.activemq.inboxcommons.MailMessage;

public class MailInputMessageDao {
	MailInputMessageBuilder mailInputMessageBuilder;
	public MailInputMessageDao() {
		mailInputMessageBuilder = new MailInputMessageBuilder();
	}
	
	public List<MailInputMessage> buildInputMessages() {
		List<MailInputMessage> inputMessages = new ArrayList<MailInputMessage>();
		inputMessages.add(new MailInputMessageBuilder().buildQueue("mailbox").buildUserName("mcure").buildMessage(new MailMessage("admin","mcure", "hi", "hey how are you?")).build());
		inputMessages.add(new MailInputMessageBuilder().buildQueue("mailbox").buildUserName("mcure").buildMessage(new MailMessage("mbross","lbross", "next level", "level up, bitches")).build());
		return inputMessages;
	}
}
