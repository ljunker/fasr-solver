package de.ljunker.fasr.model;

import de.ljunker.fasr.analysis.GraphMatcher;
import de.ljunker.fasr.calls.Call;

public class Formation {
  private final FormationGraph graph;

  public Formation(FormationGraph graph) {
    this.graph = graph;
  }

  public FormationGraph getGraph() {
    return graph;
  }

  public Formation apply(Call call) {
    return call.apply(this);
  }

  public static Formation fromGraph(FormationGraph graph) {
    return new Formation(graph);
  }

  public boolean matches(Formation other) {
    return GraphMatcher.isIsomorphic(this.graph, other.getGraph());
  }
}
