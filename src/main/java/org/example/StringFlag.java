package org.example;

import java.util.Map;

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

    @Override
    public Map<String, Object> parseFlag(String maybeParam) {
        if (maybeParam != null) {
            return Map.of(name, maybeParam);
        } else {
            return Map.of(name, EMPTY_STRING);
        }
    }
}
