package org.example;

import java.util.Map;

public record BooleanFlag(String name) implements Flag {

    @Override
    public Map<String, Object> parseFlag(String maybeParam) {
        if (maybeParam != null) {
            if (maybeParam.equals("true") ||
                    maybeParam.startsWith("-")) {
                return Map.of(name, true);
            } else if (maybeParam.equals("false")) {
                return Map.of(name, false);
            } else {
                throw new RuntimeException("Invalid arguments");
            }
        } else {
            return Map.of(name, true);
        }
    }
}
