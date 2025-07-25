package de.ljunker.fasr.model;

import de.ljunker.fasr.model.connection.BackToBackViewConnection;
import de.ljunker.fasr.model.connection.FaceToBackViewConnection;
import de.ljunker.fasr.model.connection.FacingDancerViewConnection;
import de.ljunker.fasr.model.connection.HandConnection;
import de.ljunker.fasr.model.connection.LeftHand;
import de.ljunker.fasr.model.connection.RightHand;

public class FormationTemplates {

  public static FasrGraph Lines() {
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
    graph.addEdge(B1, G1, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(B2, G2, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(B3, G3, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(B4, G4, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(G1, B2, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(G3, B4, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(B1, G4, new FacingDancerViewConnection(B1, G4));
    graph.addEdge(G1, B4, new FacingDancerViewConnection(G1, B4));
    graph.addEdge(B2, G3, new FacingDancerViewConnection(B2, G3));
    graph.addEdge(G2, B3, new FacingDancerViewConnection(G2, B3));
    return graph;
  }

  public static FasrGraph LinesTwoCouplesTraded() {
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
    graph.addEdge(B1, G1, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(B2, G2, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(B3, G3, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(B4, G4, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(G2, B1, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(G3, B4, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(B1, G3, new FacingDancerViewConnection(B1, G3));
    graph.addEdge(G1, B3, new FacingDancerViewConnection(G1, B3));
    graph.addEdge(B2, G4, new FacingDancerViewConnection(B2, G4));
    graph.addEdge(G2, B4, new FacingDancerViewConnection(G2, B4));
    return graph;
  }

  public static FasrGraph EightChain() {
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
    graph.addEdge(B1, G1, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(B2, G2, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(B3, G3, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(B4, G4, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(B1, G4, new FacingDancerViewConnection(B1, G2));
    graph.addEdge(G1, B4, new FacingDancerViewConnection(G1, B2));
    graph.addEdge(B2, G3, new FacingDancerViewConnection(B3, G4));
    graph.addEdge(G2, B3, new FacingDancerViewConnection(G3, B4));
    graph.addEdge(B1, G3, new BackToBackViewConnection(B1, G3));
    graph.addEdge(G1, B3, new BackToBackViewConnection(G1, B3));
    return graph;
  }

  public static FasrGraph RightHandedTwoFacedLines() {
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
    graph.addEdge(B1, G1, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(B2, G2, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(B3, G3, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(B4, G4, new HandConnection<RightHand, LeftHand>());
    graph.addEdge(G1, G2, new HandConnection<RightHand, RightHand>());
    graph.addEdge(G3, G4, new HandConnection<RightHand, RightHand>());
    graph.addEdge(B1, B4, new FaceToBackViewConnection(B1, B4));
    graph.addEdge(B2, B3, new FaceToBackViewConnection(B2, B3));
    graph.addEdge(G1, G4, new FaceToBackViewConnection(G1, G4));
    graph.addEdge(G2, G3, new FaceToBackViewConnection(G2, G3));
    return graph;
  }
}
