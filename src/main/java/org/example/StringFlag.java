package org.example;

import java.util.Map;
import java.util.Objects;

public record StringFlag(String name) implements Flag {

    @Override
    public Map<String, Object> parseFlag(String maybeParam) {
        return Map.of(name, Objects.requireNonNullElse(maybeParam, EMPTY_STRING));
    }
}
