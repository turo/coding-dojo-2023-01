package org.example;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class Parser {
    private Schema schema;

    public Parser(Schema schema) {
        this.schema = schema;
    }

    // Throws runtime exception when parser fails
    public Map<String, Object> parse(String arg) {
        String[] tokens = arg.split(" ");
        Map<String, Object> results = new HashMap<>();
        for (int i = 0; i < tokens.length; i++) {
            Flag maybeFlag = this.schema.getFlag(tokens[i]);
            if (maybeFlag != null) {
                Map<String, Object> parsedFlag = parseFlag(tokens, i, maybeFlag);
                results.putAll(parsedFlag);
            }
        }
        return results;
    }

    private static Map<String, Object> parseFlag(String[] tokens, int i, Flag maybeFlag) {
        if (maybeFlag.flagType == Boolean.class) {
            if (i + 1 < tokens.length) {
                if (tokens[i + 1].equals("true") ||
                        tokens[i + 1].startsWith("-")) {
                    return Map.of(maybeFlag.flagName, true);
                } else if (tokens[i + 1].equals("false")) {
                    return Map.of(maybeFlag.flagName, false);
                } else {
                    throw new RuntimeException("Invalid arguments");
                }
            } else {
                return Map.of(maybeFlag.flagName, true);
            }
        } else {
            throw new RuntimeException("Not implemented");
        }
    }

    public static void main(String[] args) {
        // defining schema

        // parsing schema
        // validation

        // parsing arguments

    }
}
