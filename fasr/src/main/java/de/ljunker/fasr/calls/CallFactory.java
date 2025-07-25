package de.ljunker.fasr.calls;

import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.Map;

public class CallFactory {
    private static final Map<String, Call> KNOWN_CALLS = Map.of(
        "Run", new Call("Run", Collections.emptySet()),
        "Bend The Line", new BendTheLine(new BendTheLineStrategy())
        // Add more calls as needed
    );

    public static Call fromString(String input) {
        String[] parts = input.trim().split("\\s+");
        Set<Modifier> modifiers = new HashSet<>();
        StringBuilder callNameBuilder = new StringBuilder();

        for (String part : parts) {
            try {
                modifiers.add(Modifier.valueOf(part.toUpperCase()));
            } catch (IllegalArgumentException e) {
                if (!callNameBuilder.isEmpty()) {
                    callNameBuilder.append(" ");
                }
                callNameBuilder.append(part);
            }
        }

        String callName = callNameBuilder.toString();
        Call baseCall = KNOWN_CALLS.get(callName);
        if (baseCall == null) {
            throw new IllegalArgumentException("Unknown call: " + callName);
        }

        // If the base call is a custom subclass, clone/copy it with modifiers if needed
        return baseCall.withModifiers(modifiers);
    }
}
