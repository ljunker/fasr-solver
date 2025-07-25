package de.ljunker.fasr.calls;

import de.ljunker.fasr.calls.exceptions.InvalidCallException;
import de.ljunker.fasr.model.Fasr;
import java.util.Set;
import java.util.Collections;

public class BendTheLine extends Call {
  private final BendTheLineStrategy callStrategy;

  public BendTheLine(BendTheLineStrategy bendTheLineStrategy) {
    this(bendTheLineStrategy, Collections.emptySet());
  }

  public BendTheLine(BendTheLineStrategy bendTheLineStrategy, Set<Modifier> modifiers) {
    super("Bend The Line", modifiers);
    this.callStrategy = bendTheLineStrategy;
  }

  public Fasr apply(Fasr fasr) throws InvalidCallException {

    return new Fasr(this.callStrategy.transform(fasr.getGraph()));
  }

  @Override
  public String getName() {
    return "Bend The Line";
  }

  @Override
  public BendTheLine withModifiers(Set<Modifier> modifiers) {
    return new BendTheLine(this.callStrategy, modifiers);
  }
}
