package de.ljunker.fasr.model.connection;

import de.ljunker.fasr.model.Dancer;
import java.util.HashSet;
import java.util.Set;

public class BackToBackViewConnection implements ViewConnection {
  private final Set<Dancer> dancers = new HashSet<>();

  public BackToBackViewConnection(Dancer d1, Dancer d2) {
    dancers.add(d1);
    dancers.add(d2);
  }

  public Set<Dancer> getDancers() {
    return dancers;
  }
}
