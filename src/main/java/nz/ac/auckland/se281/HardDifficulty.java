package nz.ac.auckland.se281;

/** This class represents the hard difficulty level of the AI. */
public class HardDifficulty implements ArtificialIntelligence {

  private Strategy topStrategy;
  private Strategy randomStrategy;
  private Strategy strategy;

  public HardDifficulty() {
    this.topStrategy = new TopStrategy();
    this.randomStrategy = new RandomStrategy();
    strategy = new RandomStrategy();
  }

  @Override
  public void setStrategy() {
    this.strategy = new RandomStrategy();
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
  public int play(int currentRound, String choice, int oddCount, int evenCount, boolean playerWin) {

    if (currentRound >= 4 && playerWin) {
      if (this.strategy instanceof RandomStrategy) {
        this.strategy = topStrategy;
      } else if (this.strategy instanceof TopStrategy) {
        this.strategy = randomStrategy;
        oddCount = 0;
        evenCount = 0;
      }
    }

    return this.strategy.getStrategy(choice, oddCount, evenCount);
  }
}
