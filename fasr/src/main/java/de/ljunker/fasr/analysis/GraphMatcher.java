package de.ljunker.fasr.analysis;

import de.ljunker.fasr.model.Connection;
import de.ljunker.fasr.model.Dancer;
import de.ljunker.fasr.model.FasrGraph;
import java.util.Comparator;
import org.jgrapht.alg.isomorphism.VF2GraphIsomorphismInspector;

public class GraphMatcher {

  public static boolean isIsomorphic(FasrGraph input, FasrGraph template) {
    VF2GraphIsomorphismInspector<Dancer, Connection> inspector =
        new VF2GraphIsomorphismInspector<>(input, template, nodeMatcher(), edgeMatcher());

    return inspector.isomorphismExists();
  }

  private static Comparator<Dancer> nodeMatcher() {
    return Comparator.comparing(o -> o.facing);
  }

  private static Comparator<Connection> edgeMatcher() {
    return Comparator.comparing(c -> c.getClass().getSimpleName());
  }
}
