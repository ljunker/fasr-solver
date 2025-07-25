package de.ljunker.fasr.calls;

import de.ljunker.fasr.calls.exceptions.InvalidCallException;
import de.ljunker.fasr.model.Fasr;

import java.util.Set;
import java.util.Collections;
import java.util.HashSet;

public class Call {
    private final String name;
    private final Set<Modifier> modifiers;

    public Call(String name, Set<Modifier> modifiers) {
        this.name = name;
        this.modifiers = Collections.unmodifiableSet(new HashSet<>(modifiers));
    }

    public String getName() {
        return name;
    }

    public Set<Modifier> getModifiers() {
        return modifiers;
    }

    public Call withModifiers(Set<Modifier> modifiers) {
        return new Call(this.name, modifiers);
    }

    public Fasr apply(Fasr fasr) throws InvalidCallException {
        throw new UnsupportedOperationException("apply() not implemented for base Call");
    }

    // equals, hashCode, toString, etc.
}

