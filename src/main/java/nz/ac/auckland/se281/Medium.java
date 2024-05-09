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

    // Game game = new Game();
    // int currentNumber = game.getCurrentInput();

    // int oddCount;
    // int evenCount;
    // if (Utils.isOdd(currentNumber)) {
    //   oddCount++;
    // } else if (Utils.isEven(currentNumber)) {
    //   evenCount++;
    // }

    int num;
    if (currentRound < 4) {
      num = randomStrategy.getStrategy(choice, oddCount, evenCount);

    } else {

      num = topStrategy.getStrategy(choice, oddCount, evenCount);
    }

    return num;
  }
}
