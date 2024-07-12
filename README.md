# JooHyuns Odd Evens Game

Odd and Evens game is a simple game.
- Setup: Two players face each other.
- Decision: One player decides if they want to be odds or evens. Let's say Player A chooses evens.
- Gameplay: Both players simultaneously show any number of fingers from 0 to 5.
- Counting: If the total number of fingers shown by both players is even (0,2,4,6,8,10), Player A wins because they chose Evens. If it's odd (1,3,5,7,9), Player B wins because they didn't choose Evens.
- Winner: The player who correctly predicted the total (odd or even) wins that round.
- Repeat: Players can play multiple rounds to determine an overall winner.

This Odd Evens Game is designed to have a human player playing against an artificial intelligence (AI) called HAL-9000. This is a game of chance but also a game of psychology. The AI will try to learn the behaviour of the human player and attempt to guess the player's next move.


To run:
1. Download all files
2. Open the folder directory on the local computer and run this prompt in the command prompt/terminal.

.\mvnw.cmd clean compile exec:java@run
