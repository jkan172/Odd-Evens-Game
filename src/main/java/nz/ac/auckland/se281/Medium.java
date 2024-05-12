package nz.ac.auckland.se281;

public class Medium implements ArtificialIntelligence {
  private Strategy topStrategy;
  private Strategy randomStrategy;

  public Medium() {
    this.topStrategy = new TopStrategy();
    this.randomStrategy = new RandomStrategy();
  }

  @Override
  public void setStrategy(Strategy strategy) {}

  @Override
  public int play(int currentRound, String choice, int oddCount, int evenCount, boolean playerWin) {

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
    return null;
  }
}
