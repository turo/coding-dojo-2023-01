package org.example;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class Schema {
    public Collection<Flag> flags;

    public Schema(Collection<Flag> flags) {
        this.flags = flags;
    }


    public Optional<Flag> getFlag(final String flagName) {
        return flags.stream()
                .filter(flag -> Objects.equals("-" + flag.getName(), flagName))
                .findFirst();
    }
}
