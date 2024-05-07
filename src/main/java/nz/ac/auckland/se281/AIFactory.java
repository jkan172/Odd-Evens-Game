package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {
  public int createAI(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        AI easy = new Easy();
        int easyNumber = easy.play();
        return easyNumber;
      case MEDIUM:
        AI medium = new Medium();
        int mediumNumber = medium.play();
        return mediumNumber;
      case HARD:
        return 0;
      default:
        MessageCli.INVALID_DIFFICULTY.printMessage();
        System.exit(0);
        return 0;
    }
  }
}
