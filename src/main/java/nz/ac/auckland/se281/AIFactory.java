package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {
  public int createAI(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
      AI easy = new Easy();
      int number = easy.play();
        return number;
      case MEDIUM:
        return 0;
      case HARD:
        return 0;
      default:
        MessageCli.INVALID_DIFFICULTY.printMessage();
        System.exit(0);
        return 0;
    }
  }
}
