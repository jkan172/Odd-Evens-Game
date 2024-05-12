package nz.ac.auckland.se281;

public interface Ai {
  public void setStrategy(Strategy strategy);

  public int play(int currentRound, String choice, int oddCount, int evenCount);

  public Strategy changeStrategy();
}
