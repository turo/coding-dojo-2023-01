package org.example;

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
        Map<String, Object> results = new HashMap<>();
        for (Flag flag : this.schema.flags) {
            if (arg.contains("-" + flag.flagName)) {
                results.put(flag.flagName, true);
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
