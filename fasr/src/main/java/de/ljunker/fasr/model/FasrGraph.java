package de.ljunker.fasr.model;

import org.jgrapht.graph.DefaultUndirectedGraph;

public class FasrGraph extends DefaultUndirectedGraph<Dancer, Connection> {
  public FasrGraph() {
    super(Connection.class);
  }
}
