package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** This class represents the medium difficulty level of the AI. */
public class MediumDifficulty implements ArtificialIntelligence {
  private Strategy strategy;

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * This method is used to play the game.
   *
   * @param currentRound the current round of the game
   * @param choice the choice of the player
   * @param oddCount the number of odd numbers
   * @param evenCount the number of even numbers
   * @param playerWin whether the player has won
   * @return a random number between 0 and 5
   */
  @Override
  public int play(int currentRound, Choice choice, int oddCount, int evenCount, boolean playerWin) {

    if (currentRound > 3) {
      setStrategy(new TopStrategy());
      return strategy.getStrategy(choice, oddCount, evenCount);
    } else {
      setStrategy(new RandomStrategy());
      return strategy.getStrategy(choice, oddCount, evenCount);
    }
  }
}
