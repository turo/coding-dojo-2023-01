package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Parser
{
    private Schema schema;

    public Parser(Schema schema) {
        this.schema = schema;
    }

    // Throws runtimeexception when parser fails
    public Map<String, Object> parse(String arg) {
        String[] tokens = arg.split(" ");
        Map<String, Object> results = new HashMap<>();
        for (int i = 0; i < tokens.length; i++) {
            for (Flag flag : this.schema.flags) {
                if (tokens[i].equals("-" + flag.flagName)) {
                    if (flag.flagType == Boolean.class) {
                        if (i + 1 < tokens.length) {
                            if (tokens[i + 1].equals("true") ||
                                    tokens[i + 1].startsWith("-")) {
                                results.put(flag.flagName, true);
                            } else if (tokens[i + 1].equals("false")) {
                                results.put(flag.flagName, false);
                            } else {
                                throw new RuntimeException("Invalid arguments");
                            }
                        } else {
                            results.put(flag.flagName, true);
                        }
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        // defining schema

        // parsing schema
        // validation

        // parsing arguments

    }
}
