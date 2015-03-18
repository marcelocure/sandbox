package com.github.marcelocure.sandbox.java.guice;

import com.google.inject.Singleton;

@Singleton
public class EmailService implements MessageService {

  public boolean sendMessage(String message, String recipient) {
      System.out.println("Email sent to "+recipient+" with message="+message);
      return true;
  }

}