package nz.ac.auckland.se281;

/** This interface represents the strategy of the AI. */
public interface Strategy {
  public int getStrategy(String choice, int oddCount, int evenCount);
}
