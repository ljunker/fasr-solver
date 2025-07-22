package de.ljunker.fasr.analysis;

import de.ljunker.fasr.model.Dancer;
import de.ljunker.fasr.model.FormationGraph;
import java.util.Comparator;
import org.jgrapht.alg.isomorphism.VF2GraphIsomorphismInspector;
import org.jgrapht.graph.DefaultEdge;

public class GraphMatcher {

  public static boolean isIsomorphic(FormationGraph input, FormationGraph template) {
    VF2GraphIsomorphismInspector<Dancer, DefaultEdge> inspector =
        new VF2GraphIsomorphismInspector<>(input, template, nodeMatcher(), edgeMatcher());

    return inspector.isomorphismExists();
  }

  private static Comparator<Dancer> nodeMatcher() {
    return Comparator.comparing((Dancer o) -> o.gender).thenComparing(o -> o.facing);
  }

  private static Comparator<DefaultEdge> edgeMatcher() {
    return Comparator.comparing(DefaultEdge::toString);
  }
}
