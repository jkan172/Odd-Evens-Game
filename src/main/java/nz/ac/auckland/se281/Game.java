package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private String playerName;
  private boolean gameStarted = false;
  private int rounds = 1;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    gameStarted = true;

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

  public void play() {
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.START_ROUND.printMessage(String.valueOf(rounds));
    rounds++;

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

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, input);
  }

  public void endGame() {}

  public void showStats() {}
}
