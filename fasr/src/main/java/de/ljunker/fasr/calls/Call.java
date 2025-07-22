package de.ljunker.fasr.calls;

import de.ljunker.fasr.model.Formation;

@FunctionalInterface
public interface Call {
  Formation apply(Formation formation);
}
