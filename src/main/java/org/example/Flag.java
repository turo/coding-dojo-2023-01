package org.example;

import java.util.Map;

public interface Flag {
    String EMPTY_STRING = "";

    String getName();
    Class getType();

    Map<String, Object> parseFlag(String maybeParam);

}


