package de.ljunker.fasr.model.connection;

import de.ljunker.fasr.model.Dancer;
import java.util.HashSet;
import java.util.Set;

public class FaceToBackViewConnection implements ViewConnection {
  private final Set<Dancer> dancers = new HashSet<>();
  private final Dancer dancerFacingIn;
  private final Dancer dancerFacingOut;

  public FaceToBackViewConnection(Dancer dancerFacingIn, Dancer dancerFacingOut) {
    dancers.add(dancerFacingIn);
    dancers.add(dancerFacingOut);
    this.dancerFacingIn = dancerFacingIn;
    this.dancerFacingOut = dancerFacingOut;
  }

  public Set<Dancer> getDancers() {
    return dancers;
  }

  @Override
  public String toString() {
    return "FaceToBackViewConnection{" + dancers + "}";
  }

  public Dancer getDancerFacingIn() {
    return dancerFacingIn;
  }

  public Dancer getDancerFacingOut() {
    return dancerFacingOut;
  }
}
