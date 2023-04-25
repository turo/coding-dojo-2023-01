package org.example;

import java.util.Map;

public interface Flag {
    String EMPTY_STRING = "";

    String name();

    Map<String, Object> parseFlag(String maybeParam);

}

// TODO: Add IntegerFlag

