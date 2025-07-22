package de.ljunker.fasr.model;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

public class FormationGraph extends DefaultUndirectedGraph<Dancer, DefaultEdge> {
  public FormationGraph() {
    super(DefaultEdge.class);
  }
}
