package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

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
    int randomNumber = Utils.getRandomNumberRange(0, 5);
    return randomNumber;
  }
}
