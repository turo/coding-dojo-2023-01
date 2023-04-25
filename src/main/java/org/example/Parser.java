package org.example;


import java.util.Collections;
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
            Flag maybeFlag = this.schema.getFlag(tokens[i]);
            if (maybeFlag != null) {
                String maybeParam = i+1 < tokens.length ? tokens[i+1] : null;
                Map<String, Object> parsedFlag = parseFlag(maybeFlag, maybeParam);
                results.putAll(parsedFlag);
            }
        }
        return results;
    }

    // current token, maybe param (null or string)
    private static Map<String, Object> parseFlag(Flag flag, String maybeParam) {
        if (flag.flagType == Boolean.class) {
            if (maybeParam != null) {
                if (maybeParam.equals("true") ||
                        maybeParam.startsWith("-")) {
                    return Map.of(flag.flagName, true);
                } else if (maybeParam.equals("false")) {
                    return Map.of(flag.flagName, false);
                } else {
                    throw new RuntimeException("Invalid arguments");
                }
            } else {
                return Map.of(flag.flagName, true);
            }
        } else if (flag.flagType == String.class) {
            if (maybeParam != null) {
                return Map.of(flag.flagName, maybeParam);
            } else {
                return Map.of(flag.flagName, EMPTY_STRING);//
            }
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
