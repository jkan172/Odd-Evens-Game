package nz.ac.auckland.se281;

public class Medium implements AI {

  @Override
  public int play() {

    Game game = new Game();

    if (game.getCurrentRound() <= 3) {
      RandomStrategy randomStrategy = new RandomStrategy();
      int num = randomStrategy.setStrategy();
      return num;
    } else {
      TopStrategy topStrategy = new TopStrategy();
      int num2 = topStrategy.setStrategy();
      return num2;
    }
  }
}
