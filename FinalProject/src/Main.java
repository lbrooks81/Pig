/*
 * Name: [Logan Brooks]
 * South Hills Username: [lbrooks81]
 */

import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static Scanner input = new Scanner(System.in);
    public static final int VICTORY_SCORE = 100;
    public static final int twoOnesRolled = -2000;
    public static final int twoOnesChecker = -1901;
    public static void main(String[] args)
    {
        final int playerOneScore = 0;
        final int playerTwoScore = 1;
        final int CPUScore = 2;
        printInstructions();
        boolean opponentSelection = opponentSelection(); //Computer = true
        String[]playerNames = getNames(opponentSelection);
        int[]scores = new int[3];
        boolean gameIsOver = false;
        int roundNum = 1;
        while(!gameIsOver)
        {
                printRoundInfo(roundNum, true, playerNames, scores, true);
                scores[playerOneScore] += logicLoop(true, false, scores[playerOneScore], playerNames);
                if(scores[playerOneScore] < twoOnesChecker) // If two ones are rolled, the score will be less than 1800
                {
                    scores[playerOneScore] = 0;
                }
                if(scores[playerOneScore] >= VICTORY_SCORE)
                {
                    gameIsOver = true;
                    System.out.println(playerNames[0] + " won!");
                    break;
                }
            wait(1000);
            if(opponentSelection)
            {
                scores[CPUScore] += logicLoop(true, true, scores[CPUScore], playerNames);
                if(scores[CPUScore] < twoOnesChecker)
                {
                    scores[CPUScore] = 0;
                }
                if(scores[CPUScore] >= VICTORY_SCORE)
                {
                    gameIsOver = true;
                    System.out.println("The computer won!");
                }
                else
                {
                    printRoundInfo(roundNum, false, playerNames, scores, true);
                    roundNum++;
                }
            }
            else
            {
                wait(1000);
                scores[playerTwoScore] += logicLoop(false, true, scores[playerTwoScore], playerNames);
                if(scores[playerTwoScore] < twoOnesChecker)
                {
                    scores[playerTwoScore] = 0;
                }
                if(scores[playerTwoScore] >= VICTORY_SCORE)
                {
                    gameIsOver = true;
                    System.out.println(playerNames[1] + " won!");
                }
                else
                {
                    printRoundInfo(roundNum, false, playerNames, scores, false);
                    roundNum++;
                }
            }
        }
        input.close();
    }
    public static void printRoundInfo(int roundNum, boolean startOfRound, String[]playerNames, int[]scores, boolean opponentChoice)
    {
        if(startOfRound)
        {
            System.out.println("-----Round " + roundNum + "-----");
            return;
        }
        if(opponentChoice)
        {
            wait(1000);
            System.out.println("\nRound " + roundNum + " scores:");
            wait(1000);
            System.out.println(playerNames[0] + ": " + scores[0]);
            wait(1000);
            System.out.println("CPU: " + scores[2] + "\n");
            wait(1000);
        }
        else
        {
            wait(1000);
            System.out.println("\nRound " + roundNum + " scores:");
            wait(1000);
            System.out.println(playerNames[0] + ": " + scores[0]);
            wait(1000);
            System.out.println(playerNames[1] + ": " + scores[1] + "\n");
            wait(1000);
        }
    }
    public static void printInstructions()
    {
        System.out.println("-------PIG-------");
        wait(1000);
        System.out.println("Two players (or one player and a computer) will take turns rolling die.");
        wait(1000);
        System.out.println("If no 1 appears, the sum of the die will be added to a running total for the turn.");
        wait(1000);
        System.out.println("The player can then choose to pass the turn, adding their running total to their bank, or roll again.");
        wait(1000);
        System.out.println("For each turn after the first, 2 times the roll number minus 1 (2 * (n-1)) will be added as a bonus.");
        wait(1000);
        System.out.println("If doubles are rolled, 10 points will be added, or 12 if two sixes are rolled.");
        wait(1000);
        System.out.println("If a 1 appears, the running total is reset to 0. If two 1's appear, the bank total is reset. The round ends after both of these.");
        wait(1000);
        System.out.println("The first player to reach 100 banked points wins. \n");
        wait(1000);
    }
    public static String[] getNames(boolean onePlayer)
    {
        System.out.print("Enter username for Player 1: ");
        String[]playerNames = new String[2];
        playerNames[0] = input.nextLine();
        System.out.print("You entered: " + playerNames[0] + ". Type \"no\" if this is incorrect or anything else to continue: ");
        String confirmation = input.nextLine();
        while(confirmation.equalsIgnoreCase("no"))
        {
            System.out.print("Enter username for Player 1: ");
            playerNames[0] = input.nextLine();
            System.out.print("You entered: " + playerNames[0] + ". Type \"no\" if this is incorrect or anything else to continue: ");
            confirmation = input.nextLine();
        }
        if(!onePlayer)
        {
            System.out.print("Enter username for Player 2: ");
            playerNames[1] = input.nextLine();
            System.out.print("You entered: " + playerNames[1] + ". Type \"no\" if this is incorrect or anything else to continue: ");
            confirmation = input.nextLine();
            while(confirmation.equalsIgnoreCase("no"))
            {
                System.out.print("Enter username for Player 1: ");
                playerNames[1] = input.nextLine();
                System.out.print("You entered: " + playerNames[1] + ". Type \"no\" if this is incorrect or anything else to continue: ");
                confirmation = input.nextLine();
            }
        }
        System.out.println("\n");
        return playerNames;
    }
    public static boolean opponentSelection()
    {
        System.out.println("This game allows you to either pass the device between two users, or to play against a computer opponent.");
        System.out.print("If you would like to play against another player, type \"Player\". \nIf you would like to play against a computer, type \"Computer\": ");
        String playerChoice = input.nextLine();
        while(!playerChoice.equalsIgnoreCase("Player") && !playerChoice.equalsIgnoreCase("Computer") )
        {
            System.out.println("Invalid input.");
            System.out.print("If you would like to play against another player, type \"Player\". \nIf you would like to play against a computer, type \"Computer\": ");
            playerChoice = input.nextLine();
        }
        return !playerChoice.equalsIgnoreCase("Player");
    }
    public static int[] rollDice()
    {
        Random rand = new Random();
        return new int[]{rand.nextInt(1,7),rand.nextInt(1,7)};
    }
    public static int scoringSystem(int score, int[]rollValues, int bonusMultiplier, int bankedScore)
    {
        final int oneOneRolled = -200;
        final int doubleScore = 10;
        final int doubleSixScore = 12;
        int subtotal;
        if(rollValues[0] == 1 && rollValues[1] == 1)
        {
            System.out.println("Two 1's were rolled. The round ends and the banked score is reset to 0.");
            score = twoOnesRolled;
            wait(1000);
            return score;
        }
        if(rollValues[0] == 1 || rollValues[1] == 1)
        {
            System.out.println("A " + rollValues[0] + " and a " + rollValues[1] + " were rolled. The round ends, no score banked.");
            score = oneOneRolled;
            wait(1000);
            return score;
        }
        if(rollValues[0] == rollValues[1] && rollValues[0] == 6)
        {
            subtotal = doubleSixScore + (2 * bonusMultiplier);
            score += subtotal;
            System.out.println("Two 6's were rolled. " + subtotal + " added to total, which is now " +
            score + ". Banked total remains " + bankedScore);
            wait(1000);
            return score;
        }
        if(rollValues[0] == rollValues[1])
        {
            subtotal = doubleScore + (2 * bonusMultiplier);
            score += subtotal;
            System.out.println("Two " + rollValues[1] + "'s were rolled. " + subtotal + " added to total, which is now "
            + score + ". Banked total remains " + bankedScore);
            wait(1000);
            return score;
        }
        subtotal = rollValues[0] + rollValues[1] + (2 * bonusMultiplier);
        score += subtotal;
        System.out.println("A " + rollValues[0] + " and a " + rollValues[1] + " were rolled. " + subtotal + " added to total, which is now "
        + score + ". Banked total remains " + bankedScore);
        wait(1000);
        return score;
    }
    public static boolean playerChoice()
    {
        System.out.println("Would you like to bank your score or roll again with an additional bonus multiplier?");
        System.out.print("Type \"bank\" to bank or \"roll\" to roll again: ");
        String playerChoice = input.nextLine();
        while(!playerChoice.equalsIgnoreCase("bank") && !playerChoice.equalsIgnoreCase("roll"))
        {
            System.out.println("Invalid input.");
            System.out.println("Would you like to bank your score or roll again with an additional bonus multiplier?");
            System.out.print("Type \"bank\" to bank or \"roll\" to roll again: ");
            playerChoice = input.nextLine();
        }
        return playerChoice.equalsIgnoreCase("roll");
    }
    public static int logicLoop(boolean opponentSelection, boolean isSecondTurn, int bankScore, String[]playerNames)
    {
        final int twoOnesCheck = -1901;
        int score = 0;
        int bonusMultiplier = 0;
        if(!isSecondTurn)
        {
            System.out.println(playerNames[0] + "'s turn");
            score = scoringSystem(score, rollDice(), bonusMultiplier, bankScore);
            if(score <= 0 && score > twoOnesCheck ) //1901 highest score possible after taking 2000 off
            {
                return 0;
            }
            if(score <= twoOnesCheck)
            {
                return twoOnesRolled;
            }
            while(playerChoice())
            {
                bonusMultiplier++;
                score = scoringSystem(score, rollDice(), bonusMultiplier, bankScore);
                if(score <= 0 && score > twoOnesCheck)
                {
                    return 0;
                }
                if(score <= twoOnesCheck)
                {
                    return twoOnesRolled;
                }
                if(score >= VICTORY_SCORE)
                {
                    return score;
                }
            }
            System.out.println(playerNames[0] + " banked " + score + " points, bringing their total to " + (bankScore + score));
            return score;
        }
        if(opponentSelection)
        {
            System.out.println("\nComputer's turn: ");
            score = scoringSystem(score, rollDice(), bonusMultiplier, bankScore);
            if(score <=0 && score > twoOnesCheck)
            {
                return 0;
            }
            if(score <= twoOnesCheck)
            {
                return twoOnesRolled;
            }
            Random rand = new Random();
            int coinFlip = rand.nextInt(0,2);
            while(coinFlip == 0)
            {
                System.out.println("The computer chose to roll again.");
                score = scoringSystem(score, rollDice(),bonusMultiplier, bankScore);
                if(score <=0 && score > twoOnesCheck)
                {
                    return 0;
                }
                if(score <= twoOnesCheck)
                {
                    return twoOnesRolled;
                }
                wait(1000);
                bonusMultiplier++;
                coinFlip = rand.nextInt(0,2);

            }
            System.out.println("The computer chose to bank " + score + " points, bringing their total to " + (bankScore + score) + "\n");
        }
        else
        {
            System.out.println("\n" + playerNames[1] + "'s turn");
            score = scoringSystem(score, rollDice(), bonusMultiplier, bankScore);
            if(score <=0 && score > twoOnesCheck)
            {
                return 0;
            }
            if(score <= twoOnesCheck)
            {
                return twoOnesRolled;
            }
            while(playerChoice())
            {
                bonusMultiplier++;
                score = scoringSystem(score, rollDice(), bonusMultiplier, bankScore);
                if(score <=0 && score > twoOnesCheck)
                {
                    return 0;
                }
                if(score <= twoOnesCheck)
                {
                    return twoOnesRolled;
                }
                if(score >= VICTORY_SCORE)
                {
                    return score;
                }
            }
            System.out.println(playerNames[1] + " banked " + score + " points, bringing their total to " + (bankScore + score) + "\n");
        }
        return score;
    }
    public static void wait(int ms) //DELAY METHOD
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException e)
        {
            //Thread.currentThread().interrupt();
        }
    }
}