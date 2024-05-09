package nz.ac.auckland.se281;

public class Easy implements AI {
  
  private Strategy strategy;

  @Override
  public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

  @Override
  public int play(int currentRound, String choice, int oddCount, int evenCount) {
    // create a random number = number

    // messageCli.PRINT_INFO_HAND.printMessage();

    RandomStrategy randomStrategy = new RandomStrategy();
    int num = randomStrategy.getStrategy(choice, 0, 0);
    return num;
  }
}
