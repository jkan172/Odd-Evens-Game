package nz.ac.auckland.se281;

public class Medium implements AI {
  private Strategy strategy;
  // private int oddCount;
  // private int evenCount;
  private Strategy topStrategy;
  private Strategy randomStrategy;

  public Medium() {
    this.topStrategy = new TopStrategy();
    this.randomStrategy = new RandomStrategy();
  }

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int play(int currentRound, String choice, int oddCount, int evenCount) {

    int num;
    if (currentRound < 4) {
      num = randomStrategy.getStrategy(choice, oddCount, evenCount);

    } else {

      num = topStrategy.getStrategy(choice, oddCount, evenCount);
    }

    return num;
  }

  @Override
  public Strategy changeStrategy() {
    // if (strategy instanceof TopStrategy)
    //   return new RandomStrategy();
    // else if (strategy instanceof RandomStrategy)
    //   return new TopStrategy();
    // else
      return null;
  }
}
