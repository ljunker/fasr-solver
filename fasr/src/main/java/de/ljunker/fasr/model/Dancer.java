package de.ljunker.fasr.model;

public class Dancer {
  public enum Gender {BOY, GIRL}
  public enum Direction {NORTH, SOUTH, EAST, WEST}

  public final String name;
  public final Gender gender;
  public final Direction facing;

  public Dancer(String name, Gender gender, Direction facing) {
    this.name = name;
    this.gender = gender;
    this.facing = facing;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Dancer)) {
      return false;
    }
    Dancer other = (Dancer) obj;
    return this.name.equals(other.name);
  }

  @Override
  public int hashCode() {
    return this.name.hashCode();
  }

  @Override
  public String toString() {
    return this.name;
  }
}
