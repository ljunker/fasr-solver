package de.ljunker.fasr;

import static org.junit.jupiter.api.Assertions.assertTrue;
import de.ljunker.fasr.calls.Call;
import de.ljunker.fasr.calls.exceptions.InvalidCallException;
import de.ljunker.fasr.model.Fasr;
import de.ljunker.fasr.model.FasrGraph;

public class FasrTestBuilder {

  private Fasr initialFasr;
  private Call call;
  private FasrGraph expectedGraph;

  private FasrTestBuilder() {
  }

  public static FasrTestBuilder starting() {
    return new FasrTestBuilder();
  }

  public FasrTestBuilder fromFormation(FasrGraph formation) {
    this.initialFasr = new Fasr(formation);
    return this;
  }

  public FasrTestBuilder applying(Call call) {
    this.call = call;
    return this;
  }

  public FasrTestBuilder expectingFormation(FasrGraph expected) {
    this.expectedGraph = expected;
    return this;
  }

  public void shouldMatch() throws InvalidCallException {
    Fasr result = initialFasr.apply(call);
    assertTrue(result.matches(Fasr.fromGraph(expectedGraph)));
  }
}
