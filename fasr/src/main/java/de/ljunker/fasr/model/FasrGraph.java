package de.ljunker.fasr.model;

import de.ljunker.fasr.model.connection.Connection;
import org.jgrapht.graph.DefaultUndirectedGraph;

public class FasrGraph extends DefaultUndirectedGraph<Dancer, Connection> {
  public FasrGraph() {
    super(Connection.class);
  }
}
