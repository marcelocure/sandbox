package com.github.marcelocure.sandbox.java.guice;

import com.google.inject.Singleton;

@Singleton
public class FacebookService implements MessageService {

  public boolean sendMessage(String message, String recipient) {
      System.out.println("Message sent to Facebook user "+recipient+" with message="+message);
      return true;
  }
}