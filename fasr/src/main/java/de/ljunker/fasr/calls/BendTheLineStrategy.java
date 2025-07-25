package de.ljunker.fasr.calls;

import de.ljunker.fasr.analysis.GraphMatcher;
import de.ljunker.fasr.calls.exceptions.InvalidCallException;
import de.ljunker.fasr.model.FasrGraph;
import de.ljunker.fasr.model.FormationTemplates;

public class BendTheLineStrategy implements TransformationStrategy {
  @Override
  public FasrGraph transform(FasrGraph input) throws InvalidCallException {
    if (!canTransform(input)) {
      throw new InvalidCallException("Bend The Line cannot be called from here.");
    }
    return performBendTransformation(input);
  }

  private FasrGraph performBendTransformation(FasrGraph input) {
    return input;
  }

  private boolean canTransform(FasrGraph input) {
    return isRightHandedTwoFacedLine(input);
  }

  private boolean isRightHandedTwoFacedLine(FasrGraph input) {
    return GraphMatcher.isIsomorphic(input, FormationTemplates.RightHandedTwoFacedLines());
  }
}
