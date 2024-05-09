package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {

  @Override
  public int getStrategy(String choice, int oddCount, int evenCount) {

    Game game = new Game();
    // int currentNumber = game.getCurrentInput();
    // Choice currentChoice = game.getCurrentChoice();
    int randomEvenNumber = Utils.getRandomEvenNumber();
    int randomOddNumber = Utils.getRandomOddNumber();
    Medium medium = new Medium();
    // int getOddCount = medium.getOddCount();
    // int getEvenCount = medium.getEvenCount();
    int newRandomNumber = Utils.getRandomNumberRange(0, 5);

    // boolean playerPrefersOdd = getOddCount > getEvenCount;
    // boolean playerPrefersEven = getEvenCount > getOddCount;

    boolean playerPrefersOdd = oddCount > evenCount;
    boolean playerPrefersEven = evenCount > oddCount;

    if (choice.equals("ODD")) {

      if (playerPrefersOdd) {
        return randomOddNumber;
      } else {
        return randomEvenNumber;
      }

    } else if (choice.equals("EVEN")) {

      if (playerPrefersOdd) {
        return randomEvenNumber;
      } else {
        return randomOddNumber;
      }
    }

    return newRandomNumber;
  }
}
