package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);


  }

  public void play() {
    int rounds = 1;
    MessageCli.START_ROUND.printMessage(String.valueOf(rounds));
    rounds++;

  }

  public void endGame() {}

  public void showStats() {}
}