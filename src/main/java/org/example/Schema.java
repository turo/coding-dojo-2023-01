package org.example;

import java.util.Collection;
import java.util.Objects;

public class Schema {
    public Collection<Flag> flags;

    public Schema(Collection<Flag> flags) {
        this.flags = flags;
    }


    public Flag getFlag(final String flagName) {
        for (Flag flag : flags) {
            if (Objects.equals("-" + flag.flagName, flagName)) {
                return flag;
            }
        }
        return null;
    }
}
