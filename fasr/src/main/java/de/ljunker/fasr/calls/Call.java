package de.ljunker.fasr.calls;

import de.ljunker.fasr.calls.exceptions.InvalidCallException;
import de.ljunker.fasr.model.Fasr;

public interface Call {
  Fasr apply(Fasr fasr) throws InvalidCallException;
  String getName();
}
