package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** This interface represents the strategy of the AI. */
public interface Strategy {
  public int getStrategy(Choice choice, int oddCount, int evenCount);
}
