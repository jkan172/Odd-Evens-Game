package nz.ac.auckland.se281;


public class TopStrategy implements Strategy {

  @Override
  public int getStrategy(String choice, int oddCount, int evenCount) {

    int randomEvenNumber = Utils.getRandomEvenNumber();
    int randomOddNumber = Utils.getRandomOddNumber();
    int newRandomNumber = Utils.getRandomNumberRange(0, 5);

    boolean playerPrefersOdd = oddCount > evenCount;

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
