package de.ljunker.fasr.calls;

import de.ljunker.fasr.calls.exceptions.InvalidCallException;
import de.ljunker.fasr.model.FasrGraph;

public interface CallStrategy {
  FasrGraph transform(FasrGraph input) throws InvalidCallException;
}
