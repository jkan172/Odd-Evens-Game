package nz.ac.auckland.se281;

/** This class represents the medium difficulty level of the AI. */
public class MediumDifficulty implements ArtificialIntelligence {
  private Strategy topStrategy;
  private Strategy strategy;

  public MediumDifficulty() {
    this.topStrategy = new TopStrategy();
    strategy = new RandomStrategy();
  }

  @Override
  public void setStrategy() {}

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

    int num = strategy.getStrategy(choice, oddCount, evenCount);
    // If the current round is less than 4, use the random strategy.
    // if (currentRound < 4) {
    //   num = randomStrategy.getStrategy(choice, oddCount, evenCount);
    //   // Otherwise, use the top strategy.
    // } else {

    //   num = topStrategy.getStrategy(choice, oddCount, evenCount);
    // }
    if (currentRound > 3) {
      num = topStrategy.getStrategy(choice, oddCount, evenCount);
    }

    return num;
  }
}
