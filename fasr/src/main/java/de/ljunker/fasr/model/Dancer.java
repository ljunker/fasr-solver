package de.ljunker.fasr.model;

public class Dancer {
  public enum Gender {BOY, GIRL}

  public final String name;
  public final Gender gender;

  public Dancer(String name, Gender gender) {
    this.name = name;
    this.gender = gender;
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
