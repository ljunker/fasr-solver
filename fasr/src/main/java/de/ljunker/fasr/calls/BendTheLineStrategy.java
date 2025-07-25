package de.ljunker.fasr.calls;

import de.ljunker.fasr.analysis.GraphMatcher;
import de.ljunker.fasr.calls.exceptions.InvalidCallException;
import de.ljunker.fasr.model.Dancer;
import de.ljunker.fasr.model.FasrGraph;
import de.ljunker.fasr.model.FormationTemplates;
import de.ljunker.fasr.model.connection.Connection;
import de.ljunker.fasr.model.connection.FaceToBackViewConnection;
import de.ljunker.fasr.model.connection.FacingDancerViewConnection;
import de.ljunker.fasr.model.connection.HandConnection;
import de.ljunker.fasr.model.connection.LeftHand;
import de.ljunker.fasr.model.connection.RightHand;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BendTheLineStrategy implements CallStrategy {
  @Override
  public FasrGraph transform(FasrGraph input) throws InvalidCallException {
    if (!canTransform(input)) {
      throw new InvalidCallException("Bend the Line requires a Right-Handed, Two-Faced Line");
    }
    // Copy the graph to avoid mutating the input
    FasrGraph graph = (FasrGraph) input.clone();

    // Find all lines: sequences of dancers connected by FacingDancerViewConnection
    List<List<Dancer>> lines = new ArrayList<>();
    Dancer oldStartOfFirstLine = null;
    Dancer oldStartOfSecondLine = null;

    for (Dancer start : graph.vertexSet()) {
      //if vertexSet has this dancer only 2 times, its an end dancer, the start of a line
      if (graph.degreeOf(start) != 2) {
        continue;
      }

      oldStartOfFirstLine = start;
      //viewConnection from this dancer is the start of the other line
      FaceToBackViewConnection connection =
          graph.outgoingEdgesOf(oldStartOfFirstLine).stream().filter(e -> e instanceof FaceToBackViewConnection)
              .map(e -> (FaceToBackViewConnection) e).findFirst()
              .orElseThrow(() -> new InvalidCallException("Bend the Line requires a FaceToBackViewConnection"));
      oldStartOfFirstLine = connection.getDancerFacingIn();
      oldStartOfSecondLine = connection.getDancerFacingOut();


      if (oldStartOfFirstLine == null || oldStartOfSecondLine == null) {
        throw new InvalidCallException("Bend the Line requires a FaceToBackViewConnection");
      }
      break;
    }

    lines.add(traverseLine(oldStartOfFirstLine, graph));
    lines.add(traverseLine(oldStartOfSecondLine, graph));

    // Remove all HandConnections and FaceToBackViewConnections in lines

    for (Connection edge : new HashSet<>(graph.edgeSet())) {
      if (edge instanceof HandConnection || edge instanceof FaceToBackViewConnection) {
        graph.removeEdge(edge);
      }
    }

    // For each line, connect ends to centers with HandConnection and FacingDancerViewConnection
    for (List<Dancer> line : lines) {
      if (line.size() % 2 != 0) {
        throw new InvalidCallException("Bend the Line requires even-length lines");
      }
      int mid = line.size() / 2;
      // left half: 0..mid-1, right half: mid..size-1
      Dancer leftEnd = line.getFirst();
      Dancer leftCenter = line.get(mid - 1);
      Dancer rightCenter = line.get(mid);
      Dancer rightEnd = line.getLast();
      graph.addEdge(leftEnd, leftCenter, new HandConnection<>(leftEnd, RightHand.class, leftCenter, LeftHand.class));
      graph.addEdge(rightEnd, rightCenter,
          new HandConnection<>(rightEnd, RightHand.class, rightCenter, LeftHand.class));
      graph.addEdge(leftEnd, rightCenter, new FacingDancerViewConnection(leftEnd, rightCenter));
      graph.addEdge(rightEnd, leftCenter, new FacingDancerViewConnection(rightEnd, leftCenter));
    }

    Dancer finalOldStartOfFirstLine = oldStartOfFirstLine;
    List<Dancer> firstLine = lines.stream().filter(l -> l.contains(finalOldStartOfFirstLine)).findFirst().orElseThrow();
    Dancer finalOldStartOfSecondLine = oldStartOfSecondLine;
    List<Dancer> secondLine =
        lines.stream().filter(l -> l.contains(finalOldStartOfSecondLine)).findFirst().orElseThrow();

    Dancer secondLineFirstPairRightDancer = secondLine.get(1);
    graph.addEdge(secondLineFirstPairRightDancer, oldStartOfFirstLine,
        new HandConnection<>(secondLineFirstPairRightDancer, RightHand.class, oldStartOfFirstLine, LeftHand.class));
    Dancer firstLineSecondPairSecondDancer = firstLine.get(2);
    Dancer secondLineSecondPairFirstDancer = secondLine.get(3);
    graph.addEdge(firstLineSecondPairSecondDancer, secondLineSecondPairFirstDancer,
        new HandConnection<>(firstLineSecondPairSecondDancer, RightHand.class, secondLineSecondPairFirstDancer,
            LeftHand.class));

    return graph;
  }

  private List<Dancer> traverseLine(Dancer start, FasrGraph graph) {
    // Traverse the line
    List<Dancer> line = new ArrayList<>();
    Dancer current = start;
    Dancer prev = null;
    Set<Dancer> visited = new HashSet<>();
    while (current != null && !visited.contains(current)) {
      line.add(current);
      visited.add(current);
      Dancer next = null;
      for (Connection edge : graph.edgesOf(current)) {
        if (edge instanceof HandConnection<?, ?>) {
          Dancer neighbor =
              graph.getEdgeSource(edge).equals(current) ? graph.getEdgeTarget(edge) : graph.getEdgeSource(edge);
          if (!neighbor.equals(prev)) {
            next = neighbor;
            break;
          }
        }
      }
      prev = current;
      current = next;
    }
    return line;
  }

  private boolean canTransform(FasrGraph input) {
    return isRightHandedTwoFacedLine(input);
  }

  private boolean isRightHandedTwoFacedLine(FasrGraph input) {
    return GraphMatcher.isIsomorphic(input, FormationTemplates.RightHandedTwoFacedLines());
  }
}
