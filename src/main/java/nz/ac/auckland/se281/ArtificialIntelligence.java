package nz.ac.auckland.se281;

/** This interface represents the artificial intelligence of the game. */
public interface ArtificialIntelligence {

  public void setStrategy();

  public int play(int currentRound, String choice, int oddCount, int evenCount, boolean playerWin);
}
