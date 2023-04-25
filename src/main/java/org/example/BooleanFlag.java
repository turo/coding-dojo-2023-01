package org.example;

public class BooleanFlag implements Flag {

    private String name;

    public BooleanFlag(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class getType() {
        return Boolean.class;
    }
}
