package de.ljunker.fasr.calls;

import de.ljunker.fasr.calls.exceptions.InvalidCallException;
import de.ljunker.fasr.model.Fasr;

public class BendTheLine implements Call {
  private final BendTheLineStrategy callStrategy;

  public BendTheLine(BendTheLineStrategy bendTheLineStrategy) {
    this.callStrategy = bendTheLineStrategy;
  }

  @Override
  public Fasr apply(Fasr fasr) throws InvalidCallException {

    return new Fasr(this.callStrategy.transform(fasr.getGraph()));
  }

  @Override
  public String getName() {
    return "Bend The Line";
  }
}
