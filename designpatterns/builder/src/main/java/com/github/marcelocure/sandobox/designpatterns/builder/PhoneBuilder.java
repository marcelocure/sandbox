package com.github.marcelocure.sandobox.designpatterns.builder;

public class PhoneBuilder {
    private Phone phone;

    public PhoneBuilder() {

    }

    public PhoneBuilder createPhone() {
        phone = new Phone();
        return this;
    }

    public PhoneBuilder withProcessor(String processor) {
        phone.setProcessor(processor);
        return this;
    }

    public PhoneBuilder withRam(String ram) {
        phone.setRam(ram);
        return this;
    }

    public PhoneBuilder withStorage(String storage) {
        phone.setStorage(storage);
        return this;
    }

    public PhoneBuilder withCamera(String camera) {
        phone.setCamera(camera);
        return this;
    }

    public Phone build() {
        return phone;
    }


}
