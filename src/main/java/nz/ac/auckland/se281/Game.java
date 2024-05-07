package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private String playerName;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  public void play() {
    int rounds = 1;
    MessageCli.START_ROUND.printMessage(String.valueOf(rounds));
    rounds++;

    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();

    boolean validInput = false;

    if ((Integer.parseInt(input) < 0) || (Integer.parseInt(input) > 5)) {
      while (!validInput) {
        MessageCli.INVALID_INPUT.printMessage();

        MessageCli.ASK_INPUT.printMessage();
        input = Utils.scanner.nextLine();

        if ((Integer.parseInt(input) >= 0) && (Integer.parseInt(input) <= 5)) {
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
