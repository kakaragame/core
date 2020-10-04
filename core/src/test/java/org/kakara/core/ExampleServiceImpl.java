package org.kakara.core;

public class ExampleServiceImpl extends ExampleService {
    public ExampleServiceImpl() {
        super(new ControllerKey("DIFFERENT_MOD", "COOL_IMPL"));
    }

    @Override
    public void doStuff() {
        System.out.println("stuff!");
    }
}
