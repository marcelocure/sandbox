package com.github.marcelocure.sandbox.designpatterns.chainOfResponsibility;

import java.util.Map;

public class Handler1 implements Handler {
    private Handler successor;

    public Handler1() {}
    public Handler1(Handler successor){
        this.successor = successor;
    }

    public void handleRequest(Map<String, String> req) {
        if (canHandle(req)) {
            handle(req);
        } else {
            this.successor.handle(req);
        }
    }

    public Map<String, String> handle(Map<String, String> req) {
        req.put("handler1", "ok");
        System.out.println(req.toString());
        return req;
    }

    public boolean canHandle(Map<String, String> req) {
        return req.get("h1").equalsIgnoreCase("authorized");
    }
}
