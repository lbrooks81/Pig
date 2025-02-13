CP132 Final Project

Specifications
Create the logic for the dice game Pig, in which a player can compete with another player. The object
of the game is to be the first to score 100 points. The user and computer take turns “rolling” a pair of
six-sided dice following these rules:
 On a turn, each player rolls two dice. If no 1 appears, the dice values are added to a running
total for the turn, and the player can choose whether to roll again or pass the turn to the other
player. When a player passes, the accumulated turn total is added to the player’s game total.
 Add 2 points for each turn the player did not pass (excluding the current turn) to the running
total for the current turn.
 If the same number appears on both die, add 10 points to the total or the sum of the dice values
if the sum of the dice values exceeds 10.
 If a 1 appears on one of the dice, the player’s turn total becomes 0; in other words, nothing
more is added to the player’s game total for that turn, and it becomes the other player’s turn.
 If a 1 appears on both of the dice, not only is the player’s turn over, but also the player’s entire
accumulated total is reset to 0.

When starting the game, the user should have the option to play against the computer or another player.
If the user decides to play against the computer, then use the following rule:
 The same logic as described above applies to computer opponents.
 When the computer does not roll a 1 and can choose whether to roll again, generate a random
value from 1 to 2. The computer then will decide to continue when the value is 1 and decide to
pass the turn to the player when the value is 2.
 Put a one-second delay between outputs for the computer.

Create a flowchart and pseudocode for the logic. These will be due before the code. After creating the
pseudocode and flowchart, translate them to an equivalent working Java program. By equivalent, I
mean that your code should have the same steps as your pseudocode and flowchart, with the exception
of Java-specific instructions, such as creating a Scanner for input.

Constraints
 You can up to three global variables. All other variables should be local.
 The dice must be represented by an array of integers.
◦ If we have not gone over integers yet, you can use two integer variables until we go over
arrays.
 Utilize good modularization practices.
 The instructions in a method should be cohesive. All instructions work together to achieve one
goal.
 There must be input validation.
 Do not use magic numbers, use constant variables.
 Pseudocode and flowcharts must not have language-specific instructions. Remember that
pseudocode and flowcharts are intended to be language-independent.
 Do not have variables in your pseudocode or flowcharts that are unused. Remove unused
variables before submitting.
 Your flowchart must be structured.
 Modules in your flowchart and pseudocode must have headers with a return type and parameter
list, even if it is empty. The return keyword must be used for both your flowchart and module.
◦ Ex: num sum(num op1, num op2) or void printInstructions()
 Follow the standard Java naming conventions.
 Your code should look clean. Avoid excessive empty lines, ensure braces are aligned properly,
etc. Use comments to document code you feel is difficult to understand at a glance.
Extra Credit
 (3 pts) Use one or no global variables. This should not be at the sacrifice of the cleanliness of
your code.
 (2 pts) When a game ends, ask the user if they would like to play again. If the user indicates
they want to play again, start a new game.
 (2 pts) Allow the user to have a username. If it is a game against two human players, allow both
players to have their own usernames. Usernames should be entered by the user.

Submissions
The first submission for this project will be your pseudocode and flowchart.

Submit only one vsdx file for your flowchart. Flowcharts should not be submitted as pdfs or any
other format beside vsdx.

Submit only one text file for your pseudocode. Acceptable file formats for your pseudocode: txt, pdf,
docx, doc, odt

You may put the two files in an archive file. Acceptable archive file types: zip, 7z, rar, tar, tar.gz

Your second submission for this project is the commit ID you want to be graded. The commit ID
should point to a valid commit in your GitHub repository. You will submit the commit ID via the
Canvas assignment. If you need help finding the commit ID, ask for help.

Commit IDs for different repositories and code that does not compile will not be graded.
See the grading rubric on Canvas for grading criteria.

Academic Dishonesty Reminder

Any work submitted by a student that is not their original work will be considered a violation of the
school’s academic dishonesty policy. This includes, but is not limited to, using AI to generate code,
using code found online, and stealing code from a classmate.

While student collaboration is permitted, sharing code with classmates will be considered a violation of
the school’s academic dishonesty policy.

Example Game Logic
 The player rolls a 2 and a 4. Their round total becomes 6. Their game total remains 0.
 The player rolls a 6 and a 5. Their round total becomes 19. Their game total remains 0.
◦ 6 + (6 + 5) + (2 * 1)
 The player rolls a 2 and 2. Their round total becomes 33. Their game total remains 0.
◦ 19 + 10 + (2 * 2)
 The player rolls a 6 and a 6. Their round total becomes 51. Their game total remains 0.
◦ 33 + (6 + 6) + (2 * 3)
 The player passes. Their game total becomes 51.
 (opponent plays)
 The player rolls a 3 and 4. Their round total becomes 7. Their game total remains 51.
 The player rolls a 3 and 3. Their round total becomes 19. The game total remains 51.
◦ 7 + (10) + (2 * 1)
 The player rolls a 1 and 6. The round ends. Their game total remains 51.
 (opponent plays)
 The player rolls a 1 and 1. The round ends. Their game total is reset to 0.
 (opponent plays)
 (Skipping large chunk of game. Player now has 66 points in the game and 22 in the round. It is
their fourth turn in the round.)
 The player rolls a 5 and 4. Their round total becomes 37. The game total remains 66.
◦ 22 + (5 + 4) + (2 * 3)
 The user passes (or the game can automatically end). The user’s game total becomes 103. The
player wins.
Annotations
