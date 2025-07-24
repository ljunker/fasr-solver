package de.ljunker.fasr.analysis;

import static org.junit.jupiter.api.Assertions.assertTrue;
import de.ljunker.fasr.model.Fasr;
import de.ljunker.fasr.model.FasrGraph;
import de.ljunker.fasr.model.FormationTemplates;
import org.junit.jupiter.api.Test;

public class BendTheLineTest {

  @Test
  void fromRightHandedTwoFacedLinesToLines() {
    FasrGraph graph = FormationTemplates.RightHandedTwoFacedLines();
    Fasr lines = new Fasr(graph);

    lines.apply(BendTheLine());

    assertTrue(GraphMatcher.isIsomorphic(lines.getGraph(), FormationTemplates.Lines()));
  }
}
