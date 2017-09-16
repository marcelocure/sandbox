package com.github.marcelocure.sandbox.designpatterns.chainOfResponsibility;

import java.util.Map;

public class Handler2 implements Handler {
    private Handler successor;

    public Handler2(Handler successor){
        this.successor = successor;
    }

    public void handleRequest(Map<String, String> req) {
        if (canHandle(req)) {
            handle(req);
        } else {
            this.successor.handleRequest(req);
        }
    }

    public Map<String, String> handle(Map<String, String> req) {
        req.put("handler2", "ok");
        System.out.println(req.toString());
        return req;
    }

    public boolean canHandle(Map<String, String> req) {
        return req.get("h2").equalsIgnoreCase("authorized");
    }
}
