package de.ljunker.fasr.calls;

import de.ljunker.fasr.model.Fasr;

@FunctionalInterface
public interface Call {
  Fasr apply(Fasr fasr);
}
