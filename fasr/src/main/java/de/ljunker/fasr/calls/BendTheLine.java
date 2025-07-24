package de.ljunker.fasr.calls;

import de.ljunker.fasr.model.Fasr;

public class BendTheLine implements Call {
  @Override
  public Fasr apply(Fasr fasr) {
    return fasr;
  }
}
