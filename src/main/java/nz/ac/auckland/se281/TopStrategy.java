package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {
  private int oddCount;
  private int evenCount;

  @Override
  public int setStrategy() {

    Game game = new Game();
    if (game.getCurrentChoice() == Choice.ODD) {

      if (Utils.isOdd(game.getCurrentInput())) {
        oddCount++;
      } else {
        evenCount++;
      }

      if (oddCount > evenCount) {
        return Utils.getRandomOddNumber();
      } else if (evenCount > oddCount) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomNumberRange(0, 5);
      }
    } else {

      if (Utils.isEven(game.getCurrentInput())) {
        evenCount++;
      } else {
        oddCount++;
      }

      if (evenCount > oddCount) {
        return Utils.getRandomOddNumber();
      } else if (oddCount > evenCount) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomNumberRange(0, 5);
      }
    }
  }
}
