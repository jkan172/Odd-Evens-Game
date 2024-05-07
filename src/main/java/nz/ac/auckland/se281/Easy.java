package nz.ac.auckland.se281;

public class Easy implements AI {
  
  @Override
  public int play() {
    // create a random number = number

    // messageCli.PRINT_INFO_HAND.printMessage();

    RandomStrategy randomStrategy = new RandomStrategy();
    int num = randomStrategy.setStrategy();
    return num;
  }
}
