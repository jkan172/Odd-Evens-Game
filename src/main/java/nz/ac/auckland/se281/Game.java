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
  private ArtificialIntelligence ai;
  private int oddCount;
  private int evenCount;
  private int playerWinCount;
  private int aiWin;

  private int intInput = -1;
  private boolean playerWin = false;

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

    // Check if the difficulty and choice are valid
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

    // creates an instance of an AI
    ai = Factory.createAi(currentDifficulty);

    oddCount = 0;
    evenCount = 0;
    playerWinCount = 0;
    aiWin = 0;
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

    // repeats to ask for input until the right number our of 0 to 5 is given
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

    int aiNumber = ai.play(rounds, currentChoice, oddCount, evenCount, playerWin);
    rounds++;

    // checks if the input is odd or even and counts it
    if (Utils.isOdd(intInput)) {
      oddCount++;
    } else if (Utils.isEven(intInput)) {
      evenCount++;
    }

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(aiNumber));

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, input);

    int sum = aiNumber + Integer.parseInt(input);

    // checks if the sum is odd or even and prints the outcome
    if (currentChoice == Choice.EVEN) {
      if (Utils.isEven(sum)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", playerName);
        playerWin = true;
        playerWinCount++;

      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", "HAL-9000");
        aiWin++;
        playerWin = false;
      }
    } else {
      if (Utils.isOdd(sum)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", playerName);
        playerWin = true;
        playerWinCount++;

      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", "HAL-9000");
        aiWin++;
        playerWin = false;
      }
    }
  }

  /** Ends the game and prints the winner of the game. */
  public void endGame() {
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // prints the number of rounds won by the player and the AI
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, String.valueOf(playerWinCount), String.valueOf(aiWin));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", String.valueOf(aiWin), String.valueOf(playerWinCount));

    // prints the winner of the game
    if (playerWinCount > aiWin) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (playerWinCount < aiWin) {
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

    // prints the number of rounds won by the player and the AI
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, String.valueOf(playerWinCount), String.valueOf(aiWin));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", String.valueOf(aiWin), String.valueOf(playerWinCount));
  }
}
