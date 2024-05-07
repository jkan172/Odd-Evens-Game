package nz.ac.auckland.se281;



public class RandomStrategy implements Strategy {
  public int setStrategy() {
    int randomNumber = Utils.getRandomNumberRange(0, 5);
    return randomNumber;
  }
}
