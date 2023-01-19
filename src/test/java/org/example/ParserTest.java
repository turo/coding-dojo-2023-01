package org.example;

import org.junit.jupiter.api.Test;

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
        String arg = "-l";
        List<Flag> flags = new ArrayList<>();
        flags.add(new Flag("l", Boolean.class));
        Parser parser = new Parser(
                new Schema(flags)
        );
        Map<String, Object> parsedResults = parser.parse(arg);
        assertTrue((boolean)parsedResults.get("l"));
    }

    @Test
    public void booleanArgument_withStringValue_throwsException() {
        String arg = "-l abc";
        List<Flag> flags = new ArrayList<>();
        flags.add(new Flag("l", Boolean.class));
        Parser parser = new Parser(
                new Schema(flags)
        );

        assertThrows(RuntimeException.class,() -> parser.parse(arg));

    }
}
