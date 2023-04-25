package org.example;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class ParserTest {
    @Test
    public void emptyArgument_shouldReturnEmptyResult() {
        String arg = "";

        Parser parser = new Parser(new Schema(new ArrayList<Flag>()));
        // Fail fast
        Map<String, Object> parsedResults = parser.parse(arg);
        assertNotNull(parsedResults);
        assertEquals(parsedResults.size(), 0);
    }

    @Test
    public void booleanArgument_returnsMapWithTrueValue() {
        var arg = "-l";
        List<Flag> flags = List.of(new BooleanFlag("l"));
        Parser parser = new Parser(new Schema(flags));
        Map<String, Object> parsedResults = parser.parse(arg);
        assertTrue((boolean) parsedResults.get("l"));
    }

    @Test
    void stringArgument_returnsMapWithStringValue() {
        var arg = "-l abc";
        List<Flag> flags = List.of(new StringFlag("l"));
        Parser parser = new Parser(new Schema(flags));
        Map<String, Object> parsedResults = parser.parse(arg);
        assertEquals("abc", parsedResults.get("l"));
    }

    @Test
    public void multiBooleanArguments_returnsMapWithValues() {
        String arg = "-l true -i true";
        Map<String, Object> expected = Map.of("l", true, "i", true);

        List<Flag> flags = List.of(
                new BooleanFlag("l"),
                new BooleanFlag("i"));
        Parser parser = new Parser(new Schema(flags));
        Map<String, Object> parsedResults = parser.parse(arg);

        assertEquals(expected, parsedResults);
    }

    @Test
    public void booleanArgument_withStringValue_throwsException() {
        String arg = "-l abc";

        List<Flag> flags = List.of(new BooleanFlag("l"));
        Parser parser = new Parser(new Schema(flags));

        assertThrows(RuntimeException.class, () -> parser.parse(arg));

    }
}
