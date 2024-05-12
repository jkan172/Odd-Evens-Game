package nz.ac.auckland.se281;

public class Easy implements ArtificialIntelligence {

  @Override
  public void setStrategy(Strategy strategy) {}

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
