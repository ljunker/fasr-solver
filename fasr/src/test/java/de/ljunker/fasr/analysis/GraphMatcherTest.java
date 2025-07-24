package de.ljunker.fasr.analysis;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import de.ljunker.fasr.model.FasrGraph;
import de.ljunker.fasr.model.FormationTemplates;
import org.junit.jupiter.api.Test;

class GraphMatcherTest {

  @Test
  void testIsIsomorphic() {
    FasrGraph graph1 = FormationTemplates.Lines();
    FasrGraph graph2 = FormationTemplates.LinesTwoCouplesTraded();

    assertTrue(GraphMatcher.isIsomorphic(graph1, graph2));
  }

  @Test
  void linesNotIsomorphToEightChain() {
    FasrGraph lines = FormationTemplates.Lines();
    FasrGraph eightChain = FormationTemplates.EightChain();

    assertFalse(GraphMatcher.isIsomorphic(lines, eightChain));
  }

}