package de.ljunker.fasr.model;

import java.util.HashSet;
import java.util.Set;

public abstract class Connection {

  final Set<Dancer> dancers = new HashSet<>();

  public Connection(Dancer d1, Dancer d2) {
    dancers.add(d1);
    dancers.add(d2);
  }

  public Set<Dancer> getDancers() {
    return dancers;
  }
}
