package de.ljunker.fasr.model;

import de.ljunker.fasr.analysis.GraphMatcher;
import de.ljunker.fasr.calls.Call;
import de.ljunker.fasr.calls.exceptions.InvalidCallException;

public class Fasr {
  private final FasrGraph graph;

  public Fasr(FasrGraph graph) {
    this.graph = graph;
  }

  public FasrGraph getGraph() {
    return graph;
  }

  public Fasr apply(Call call) throws InvalidCallException {
    return call.apply(this);
  }

  public static Fasr fromGraph(FasrGraph graph) {
    return new Fasr(graph);
  }

  public boolean matches(Fasr other) {
    return GraphMatcher.isIsomorphic(this.graph, other.getGraph());
  }
}
