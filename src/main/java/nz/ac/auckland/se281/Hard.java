package nz.ac.auckland.se281;

public class Hard implements AI {

  private Strategy strategy;

  @Override
  public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

  @Override
  public int play(int currentRound) {
    return 0;
  }
}
