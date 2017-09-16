package com.github.marcelocure.sandbox.designpatterns.chainOfResponsibility;

import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {
        Map<String, String> req = getRequest();
        Handler handler1 = new Handler1();
        Handler handler2 = new Handler2(handler1);
        handler2.handleRequest(req);
    }

    public static Map<String, String> getRequest() {
        Map<String, String> req = new HashMap<String, String>();
        req.put("h1", "authorized");
        req.put("h2", "unauthorized");
        return req;
    }
}
