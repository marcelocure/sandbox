package com.github.marcelocure.sandbox.java.activemq.inboxproducer;

import org.junit.Assert;
import org.junit.Test;

import com.github.marcelocure.sandbox.java.activemq.inboxcommons.MailMessage;

public class InputMessageBuilderTest {

	@Test
	public void testBuildQueue() {
		MailInputMessageBuilder mailInputMessageBuilder = new MailInputMessageBuilder();
		MailInputMessage mailInputMessage = mailInputMessageBuilder.buildQueue("test").build();
		Assert.assertEquals("test", mailInputMessage.getQueue());
	}
	
	@Test
	public void testBuildUserName() {
		MailInputMessageBuilder mailInputMessageBuilder = new MailInputMessageBuilder();
		MailInputMessage mailInputMessage = mailInputMessageBuilder.buildUserName("mcure").build();
		Assert.assertEquals("mcure", mailInputMessage.getUserName());
	}
	
	@Test
	public void testBuildMailMessage() {
		MailInputMessageBuilder mailInputMessageBuilder = new MailInputMessageBuilder();
		MailInputMessage mailInputMessage = mailInputMessageBuilder.buildMessage(new MailMessage("mcure","czenki","meow","cats usually meow")).build();
		Assert.assertEquals("mcure", mailInputMessage.getMessage().getFrom());
		Assert.assertEquals("czenki", mailInputMessage.getMessage().getTo());
		Assert.assertEquals("meow", mailInputMessage.getMessage().getSubject());
		Assert.assertEquals("cats usually meow", mailInputMessage.getMessage().getMessage());
	}
}
