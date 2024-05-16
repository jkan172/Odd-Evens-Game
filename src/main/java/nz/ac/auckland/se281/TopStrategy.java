package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** This class represents a top strategy for the AI. */
public class TopStrategy implements Strategy {

  /**
   * This method returns a random number between 0 and 5.
   *
   * @param choice The choice of the player.
   * @param oddCount The number of odd numbers.
   * @param evenCount The number of even numbers.
   * @return A random number between 0 and 5.
   */
  @Override
  public int getStrategy(Choice choice, int oddCount, int evenCount) {

    int randomEvenNumber = Utils.getRandomEvenNumber();
    int randomOddNumber = Utils.getRandomOddNumber();
    int newRandomNumber = Utils.getRandomNumberRange(0, 5);

    boolean playerPrefersOdd = oddCount > evenCount;
    boolean playerPreferBoth = oddCount == evenCount;
    // If the player chooses ODD for choice this game
    if (choice == Choice.ODD) {
      if (playerPrefersOdd) {
        return randomOddNumber;
        // return 1;
      } else if (playerPreferBoth) {
        return newRandomNumber;
        // return 3;
      } else {
        return randomEvenNumber;
        // return 2;
      }
      // If the player chooses EVEN for choice this game
    } else {
      if (playerPrefersOdd) {
        return randomEvenNumber;
        // return 2;
      } else if (playerPreferBoth) {
        return newRandomNumber;
        // return 3;
      } else {
        return randomOddNumber;
        // return 1;
      }
    }
  }
}
