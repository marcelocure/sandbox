package com.github.marcelocure.sandbox.java.guice;

import com.google.inject.AbstractModule;
 
public class AppInjector extends AbstractModule {
 
    @Override
    protected void configure() {
        bind(MessageService.class).to(EmailService.class);
    }
}