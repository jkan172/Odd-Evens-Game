package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private String playerName;
  private boolean gameStarted = false;
  private int rounds;
  private Difficulty currentDifficulty;
  private Choice currentChoice;
  private AI ai = null;
  private int oddCount = 0;
  private int evenCount = 0;

  /**
   * Starts a new game with the given difficulty, choice, and options.
   *
   * @param difficulty level of difficulty EASY, MEDIUM, HARD
   * @param choice odd or even
   * @param options name of the player
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    gameStarted = true;
    rounds = 1;
    this.currentDifficulty = difficulty;
    currentChoice = choice;

    if (difficulty != Difficulty.EASY
        && difficulty != Difficulty.MEDIUM
        && difficulty != Difficulty.HARD) {
      MessageCli.INVALID_DIFFICULTY.printMessage();
      return;
    } else if (choice != Choice.EVEN && choice != Choice.ODD) {
      MessageCli.INVALID_CHOICE.printMessage();
      return;
    }

    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  /** Plays a round of the game if the new game is created. */
  public void play() {
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.START_ROUND.printMessage(String.valueOf(rounds));

    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();

    boolean validInput = false;
    int intInput = Integer.parseInt(input);

    if ((intInput < 0) || intInput > 5) {
      while (!validInput) {
        MessageCli.INVALID_INPUT.printMessage();

        MessageCli.ASK_INPUT.printMessage();
        input = Utils.scanner.nextLine();
        intInput = Integer.parseInt(input);

        if ((intInput >= 0) && (intInput <= 5)) {
          validInput = true;

          break;
        }
      }
    }

    if (Utils.isOdd(intInput)) {
      oddCount++;
    } else if (Utils.isEven(intInput)) {
      evenCount++;
    }

    ai = AIFactory.createAI(currentDifficulty);
    int aiNumber = ai.play(rounds, currentChoice.toString(), oddCount, evenCount);
    rounds++;

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(aiNumber));

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, input);

    int sum = aiNumber + Integer.parseInt(input);

    if (currentChoice == Choice.EVEN) {
      if (Utils.isEven(sum)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", playerName);
        if (currentDifficulty == Difficulty.HARD) {
          ai.changeStrategy();
        }
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", "HAL-9000");
      }
    } else {
      if (Utils.isOdd(sum)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", playerName);
        if (currentDifficulty == Difficulty.HARD) {
          ai.changeStrategy();
        }
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", "HAL-9000");
      }
    }
  }

  public void endGame() {}

  public void showStats() {}
}
