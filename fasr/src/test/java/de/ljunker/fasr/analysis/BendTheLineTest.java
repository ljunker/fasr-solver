package de.ljunker.fasr.analysis;

import de.ljunker.fasr.FasrTestBuilder;
import de.ljunker.fasr.calls.CallFactory;
import de.ljunker.fasr.calls.exceptions.InvalidCallException;
import de.ljunker.fasr.model.FormationTemplates;
import org.junit.jupiter.api.Test;

public class BendTheLineTest {

  @Test
  void fromRightHandedTwoFacedLinesToLines() throws InvalidCallException {
    FasrTestBuilder
        .starting()
        .fromFormation(FormationTemplates.RightHandedTwoFacedLines())
        .applying(CallFactory.bendTheLine())
        .expectingFormation(FormationTemplates.Lines())
        .shouldMatch();
  }

}
