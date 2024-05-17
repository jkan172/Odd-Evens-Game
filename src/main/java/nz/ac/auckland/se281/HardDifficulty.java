package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** This class represents the hard difficulty level of the AI. */
public class HardDifficulty implements ArtificialIntelligence {

  private Strategy strategy;

  public HardDifficulty() {
    strategy = new RandomStrategy();
  }

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * This method is used to play the game. This method changes the strategy of the AI after 3 rounds
   * if the player wins and the AI loses.
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

    // Change strategy after 3 rounds if the player wins and the AI loses
    if (currentRound > 3 && playerWin) {
      // if it's an instance of RandomStrategy, change to TopStrategy
      if (this.strategy instanceof RandomStrategy) {
        setStrategy(new TopStrategy());
        // if it's an instance of TopStrategy, change to RandomStrategy
      } else if (this.strategy instanceof TopStrategy) {
        setStrategy(new RandomStrategy());
      }
    }

    return strategy.getStrategy(choice, oddCount, evenCount);
  }
}
