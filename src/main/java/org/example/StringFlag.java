package org.example;

public class StringFlag implements Flag {

    private String name;

    public StringFlag(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class getType() {
        return String.class;
    }
}
