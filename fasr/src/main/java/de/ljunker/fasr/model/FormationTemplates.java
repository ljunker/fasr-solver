package de.ljunker.fasr.model;

import de.ljunker.fasr.model.connection.CoupleHandConnection;
import de.ljunker.fasr.model.connection.FacingDancerViewConnection;

public class FormationTemplates {

  public static FasrGraph LinesNorthSouth() {
    FasrGraph graph = new FasrGraph();
    Dancer B1 = new Dancer("B1", Dancer.Gender.BOY);
    Dancer B2 = new Dancer("B2", Dancer.Gender.BOY);
    Dancer B3 = new Dancer("B3", Dancer.Gender.BOY);
    Dancer B4 = new Dancer("B4", Dancer.Gender.BOY);
    Dancer G1 = new Dancer("G1", Dancer.Gender.GIRL);
    Dancer G2 = new Dancer("G2", Dancer.Gender.GIRL);
    Dancer G3 = new Dancer("G3", Dancer.Gender.GIRL);
    Dancer G4 = new Dancer("G4", Dancer.Gender.GIRL);
    graph.addVertex(B1);
    graph.addVertex(B2);
    graph.addVertex(B3);
    graph.addVertex(B4);
    graph.addVertex(G1);
    graph.addVertex(G2);
    graph.addVertex(G3);
    graph.addVertex(G4);
    graph.addEdge(B1, G1, new CoupleHandConnection());
    graph.addEdge(B2, G2, new CoupleHandConnection());
    graph.addEdge(B3, G3, new CoupleHandConnection());
    graph.addEdge(B4, G4, new CoupleHandConnection());
    graph.addEdge(B1, G4, new FacingDancerViewConnection(B1, G4));
    graph.addEdge(G2, B4, new FacingDancerViewConnection(G2, B4));
    graph.addEdge(B2, G3, new FacingDancerViewConnection(B2, G3));
    graph.addEdge(G2, B3, new FacingDancerViewConnection(G2, B3));
    return graph;
  }
}
