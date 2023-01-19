package org.example;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class ParserTest
{
    @Test
    public void emptyArgument_shouldReturnEmptyResult()
    {
        String arg = "";

        Parser parser = new Parser();
        // Fail fast
        Map<String, Object> parsedResults = parser.parse(arg);
        assertNotNull(parsedResults);
        assertEquals(parsedResults.size(), 0);
    }
}
