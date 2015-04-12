package com.github.marcelocure.sandbox.java.activemq.inboxproducer;

import java.io.Serializable;

import com.github.marcelocure.sandbox.java.activemq.inboxcommons.MailMessage;

public class MailInputMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	private String queue;
	private MailMessage message;
	private String userName;

	public MailInputMessage(String queue, MailMessage message, String userName) {
		this.queue = queue;
		this.message = message;
		this.userName = userName;
	}

	public MailInputMessage() {
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public MailMessage getMessage() {
		return message;
	}

	public void setMessage(MailMessage message) {
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((queue == null) ? 0 : queue.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MailInputMessage other = (MailInputMessage) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (queue == null) {
			if (other.queue != null)
				return false;
		} else if (!queue.equals(other.queue))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
}
