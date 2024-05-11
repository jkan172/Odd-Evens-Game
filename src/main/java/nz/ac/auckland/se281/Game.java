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
  private Strategy otherStrategy = null;
  private int playerWin = 0;
  private int aiWin = 0;

  private int intInput = -1;

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
    String[] inputArray = input.split(" ");
    boolean validInput = false;

    while (!validInput) {
      boolean multipleInput = inputArray.length > 1;
      boolean isInteger = Utils.isInteger(input);
      intInput = -1;

      if (!multipleInput) {
        try {
          intInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
          isInteger = false;
        }
      }
      if (intInput < 0 || intInput > 5 || multipleInput || !isInteger) {
        MessageCli.INVALID_INPUT.printMessage();
        MessageCli.ASK_INPUT.printMessage();
        input = Utils.scanner.nextLine();
        inputArray = input.split(" ");
      } else {
        validInput = true;
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
          otherStrategy = ai.changeStrategy();
          ai.setStrategy(otherStrategy);
        }
        playerWin++;

      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", "HAL-9000");
        aiWin++;
      }
    } else {
      if (Utils.isOdd(sum)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", playerName);
        if (currentDifficulty == Difficulty.HARD) {
          otherStrategy = ai.changeStrategy();
          ai.setStrategy(otherStrategy);
        }
        playerWin++;

      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", "HAL-9000");
        aiWin++;
      }
    }
  }

  /** Ends the game and prints the winner of the game. */
  public void endGame() {
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    if (playerWin > aiWin) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (playerWin < aiWin) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    gameStarted = false;
  }

  /** Shows the statistics of the game. */
  public void showStats() {
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, String.valueOf(playerWin), String.valueOf(aiWin));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", String.valueOf(aiWin), String.valueOf(playerWin));
  }
}
