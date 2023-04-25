package org.example;


import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class Parser {
    public static final String EMPTY_STRING = "";
    private Schema schema;

    public Parser(Schema schema) {
        this.schema = schema;
    }

    // Throws runtime exception when parser fails
    public Map<String, Object> parse(String arg) {
        String[] tokens = arg.split(" ");
        Map<String, Object> results = new HashMap<>();
        for (int i = 0; i < tokens.length; i++) {
            var maybeFlag = this.schema.getFlag(tokens[i]);
            if (maybeFlag.isPresent()) {
                String maybeParam = i + 1 < tokens.length ? tokens[i + 1] : null;
                Map<String, Object> parsedFlag = parseFlag(maybeFlag.get(), maybeParam);
                results.putAll(parsedFlag);
            }
        }
        return results;
    }

    // current token, maybe param (null or string)
    private static Map<String, Object> parseFlag(Flag flag, String maybeParam) {
        if (flag.getType() == Boolean.class) {
            return flag.parseFlag(maybeParam);
        } else if (flag.getType() == String.class) {
            return flag.parseFlag(maybeParam);
        } else {
            throw new RuntimeException("Not implemented");
        }
    }

    // parse boolean

    // parse string

    // parse int

    public static void main(String[] args) {
        // defining schema

        // parsing schema
        // validation

        // parsing arguments

    }
}
