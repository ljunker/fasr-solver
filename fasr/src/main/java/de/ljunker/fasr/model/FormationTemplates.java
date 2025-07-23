package de.ljunker.fasr.model;

public class FormationTemplates {

  public static FasrGraph LinesNorthSouth() {
    FasrGraph graph = new FasrGraph();
    Dancer B1 = new Dancer("B1", Dancer.Gender.BOY, Dancer.Direction.NORTH);
    Dancer B2 = new Dancer("B2", Dancer.Gender.BOY, Dancer.Direction.NORTH);
    Dancer B3 = new Dancer("B3", Dancer.Gender.BOY, Dancer.Direction.SOUTH);
    Dancer B4 = new Dancer("B4", Dancer.Gender.BOY, Dancer.Direction.SOUTH);
    Dancer G1 = new Dancer("G1", Dancer.Gender.GIRL, Dancer.Direction.NORTH);
    Dancer G2 = new Dancer("G2", Dancer.Gender.GIRL, Dancer.Direction.NORTH);
    Dancer G3 = new Dancer("G3", Dancer.Gender.GIRL, Dancer.Direction.SOUTH);
    Dancer G4 = new Dancer("G4", Dancer.Gender.GIRL, Dancer.Direction.SOUTH);
    graph.addVertex(B1);
    graph.addVertex(B2);
    graph.addVertex(B3);
    graph.addVertex(B4);
    graph.addVertex(G1);
    graph.addVertex(G2);
    graph.addVertex(G3);
    graph.addVertex(G4);
    graph.addEdge(B1, G1, new HandConnection(B1, G1));
    graph.addEdge(B2, G2, new HandConnection(B2, G2));
    graph.addEdge(B3, G3, new HandConnection(B3, G3));
    graph.addEdge(B4, G4, new HandConnection(B4, G4));
    graph.addEdge(B1, G4, new ViewConnection(B1, G4));
    graph.addEdge(G2, B4, new ViewConnection(G2, B4));
    graph.addEdge(B2, G3, new ViewConnection(B2, G3));
    graph.addEdge(G2, B3, new ViewConnection(G2, B3));
    return graph;
  }
}
