package com.github.marcelocure.sandbox.designpatterns.chainOfResponsibility;

import java.util.Map;

public interface Handler {
    void handleRequest(Map<String, String> req);
    Map<String, String> handle(Map<String, String> req);
    boolean canHandle(Map<String, String> req);
}
