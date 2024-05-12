package nz.ac.auckland.se281;

/** This class represents an easy AI. */
public class EasyDifficulty implements ArtificialIntelligence {

  @Override
  public void setStrategy(Strategy strategy) {}

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
    RandomStrategy randomStrategy = new RandomStrategy();
    int num = randomStrategy.getStrategy(choice, 0, 0);
    return num;
  }

  @Override
  public Strategy changeStrategy() {
    return null;
  }
}
