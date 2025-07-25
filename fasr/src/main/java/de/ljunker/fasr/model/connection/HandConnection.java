package de.ljunker.fasr.model.connection;

import de.ljunker.fasr.model.Dancer;

public class HandConnection<S extends Hand, T extends Hand> implements Connection {
  private final Dancer dancer1;
  private final Dancer dancer2;
  private final Class<?> handType1;
  private final Class<?> handType2;

  public HandConnection(Dancer dancer1, Class<S> handType1, Dancer dancer2, Class<T> handType2) {
    this.dancer1 = dancer1;
    this.handType1 = handType1;
    this.dancer2 = dancer2;
    this.handType2 = handType2;
  }

  @Override
  public String toString() {
    return "HandConnection{" + dancer1 + ":" + handType1.getSimpleName() + ", " + dancer2 + ":" + handType2.getSimpleName() + "}";
  }
}
