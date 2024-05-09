package nz.ac.auckland.se281;

public class Medium implements AI {
  private Strategy strategy;
  private int oddCount = 0;
  private int evenCount = 0;
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
  public int play(int currentRound) {

    Game game = new Game();
    int currentNumber = game.getCurrentInput();
    

    if (Utils.isOdd(currentNumber)) {
      oddCount++;
    } else if (Utils.isEven(currentNumber)) {
      evenCount++;
    }

   
    int num;
    if (currentRound < 4) {
      num = randomStrategy.getStrategy();
      
    } else {
      
      num = topStrategy.getStrategy();
    }

    return num;
  }

  public int getOddCount() {
    return this.oddCount;
  }

  public int getEvenCount() {
    return this.evenCount;
  }
}
