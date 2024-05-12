package nz.ac.auckland.se281;

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
  public int getStrategy(String choice, int oddCount, int evenCount) {

    int randomEvenNumber = Utils.getRandomEvenNumber();
    int randomOddNumber = Utils.getRandomOddNumber();
    int newRandomNumber = Utils.getRandomNumberRange(0, 5);

    boolean playerPrefersOdd = oddCount > evenCount;
    // If the player chooses ODD for choice this game
    if (choice.equals("ODD")) {
      if (playerPrefersOdd) {
        return randomOddNumber;
      } else {
        return randomEvenNumber;
      }
      // If the player chooses EVEN for choice this game
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
