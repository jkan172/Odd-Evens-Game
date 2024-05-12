package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

/**
 * This class is a factory class that creates an AI based on the difficulty level.
 *
 * @param difficulty The difficulty level of the AI.
 * @return An AI object based on the difficulty level.
 */
public class Factory {

  /**
   * This method creates an AI object based on the difficulty level.
   *
   * @param difficulty The difficulty level of the AI.
   * @return An AI object based on the difficulty level.
   */
  public static ArtificialIntelligence createAi(Difficulty difficulty) {
    // Create an AI object based on the difficulty level.
    switch (difficulty) {
      case EASY:
        return new EasyDifficulty();
      case MEDIUM:
        return new MediumDifficulty();
      case HARD:
        return new HardDifficulty();
      default:
        MessageCli.INVALID_DIFFICULTY.printMessage();
        System.exit(0);
        return null;
    }
  }
}
