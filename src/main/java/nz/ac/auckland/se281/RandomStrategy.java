package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public int getStrategy() {
    int randomNumber = Utils.getRandomNumberRange(0, 5);
    return randomNumber;
  }
}
