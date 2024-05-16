package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** This interface represents the artificial intelligence of the game. */
public interface ArtificialIntelligence {

  public void setStrategy(Strategy strategy);

  public int play(int currentRound, Choice choice, int oddCount, int evenCount, boolean playerWin);
}
