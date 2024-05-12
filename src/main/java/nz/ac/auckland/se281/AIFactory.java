package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

/**
 * This class is a factory class that creates an AI based on the difficulty level.
 *
 * @param difficulty The difficulty level of the AI.
 * @return An AI object based on the difficulty level.
 */
public class AIFactory {
  public static ArtificialIntelligence createAi(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new Easy();
      case MEDIUM:
        return new Medium();
      case HARD:
        return new Hard();
      default:
        MessageCli.INVALID_DIFFICULTY.printMessage();
        System.exit(0);
        return null;
    }
  }
}
