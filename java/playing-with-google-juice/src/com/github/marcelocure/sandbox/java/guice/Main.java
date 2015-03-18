package com.github.marcelocure.sandbox.java.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
	 public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppInjector());        
        MessageApplication messageApplication = injector.getInstance(MessageApplication.class);
        messageApplication.sendMessage("Hi Cure", "marcelocure@gmail.com");
    }
}
