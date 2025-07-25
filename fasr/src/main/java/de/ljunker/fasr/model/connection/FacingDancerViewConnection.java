package de.ljunker.fasr.model.connection;

import de.ljunker.fasr.model.Dancer;
import java.util.HashSet;
import java.util.Set;

public class FacingDancerViewConnection implements ViewConnection {

  private final Set<Dancer> dancers = new HashSet<>();

  public FacingDancerViewConnection(Dancer d1, Dancer d2) {
    dancers.add(d1);
    dancers.add(d2);
  }

  public Set<Dancer> getDancers() {
    return dancers;
  }

  @Override
  public String toString() {
    return "FacingDancerViewConnection{" + dancers + "}";
  }
}
