package nz.ac.auckland.se281;

public class Hard implements Ai {

  private Strategy strategy;
  private Strategy topStrategy;
  private Strategy randomStrategy;

  public Hard() {
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
    if (currentRound < 4 || strategy == randomStrategy) {
      num = randomStrategy.getStrategy(choice, oddCount, evenCount);

    } else {

      num = topStrategy.getStrategy(choice, oddCount, evenCount);
    }

    return num;
  }

  @Override
  public Strategy changeStrategy() {
    // if (strategy instanceof TopStrategy) {
    //   return new RandomStrategy();

    // } else
    //   return null;
    return randomStrategy;
  }
}
