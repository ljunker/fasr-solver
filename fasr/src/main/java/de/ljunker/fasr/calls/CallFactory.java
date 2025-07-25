package de.ljunker.fasr.calls;

public class CallFactory {
  public static Call bendTheLine() {
    return new BendTheLine(new BendTheLineStrategy());
  }
}
