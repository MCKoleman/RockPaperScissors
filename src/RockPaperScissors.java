import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();

        // Keep track of player stats
        int numGames = 0;
        int numWins = 0;
        int numLosses = 0;
        int numTies = 0;
        float winPercent = 0.0f;
        boolean exit = false;

        System.out.println("Welcome to Rock Paper Scissors!\n");
        while(!exit) {
            // Show game menu
            System.out.println("Choose an option:");
            System.out.println("[1] Play Rock Paper Scissors");
            System.out.println("[2] View stats");
            System.out.println("[3] Exit game");

            // Get user selection
            int selection = 0;
            while(true) {
                String input = sc.nextLine();
                try {
                    selection = Integer.parseInt(input);
                } catch(NumberFormatException ignored) {}

                if(selection == 1 || selection == 2 || selection == 3) {
                    break;
                }
                System.out.println("Invalid input: Must be 1, 2, or 3!");
            }

            // Check selection
            switch (selection) {
                case 1: // Game
                    while(true) {
                        // Ask player for input
                        System.out.println("\nStarted new round, choose an option:");
                        System.out.println("[1] Rock");
                        System.out.println("[2] Paper");
                        System.out.println("[3] Scissors");

                        // Get user selection
                        selection = 0;
                        while(true) {
                            String input = sc.nextLine();
                            try {
                                selection = Integer.parseInt(input);
                            } catch(NumberFormatException ignored) {}

                            if(selection == 1 || selection == 2 || selection == 3) {
                                break;
                            }
                            System.out.println("Invalid input: Must be 1, 2, or 3!");
                        }

                        // Get enemy input
                        int enemySelection = rng.nextInt(3) + 1;
                        System.out.println("Player chose " + getOption(selection)
                                + ", opponent chose " + getOption(enemySelection) + ".");

                        // Check for winner
                        // Rock: 1, Paper: 2, Scissors: 3
                        // 3 beats 2, 2 beats 1, 1 beats 3
                        if(selection == enemySelection) { // Tie
                            numTies++;
                            System.out.println("It's a tie!");
                        } else if((selection == 3 && enemySelection == 2)
                                || (selection == 2 && enemySelection == 1)
                                || (selection == 1 && enemySelection == 3)) { // Win
                            numWins++;
                            System.out.println("You win!");
                        } else { // Loss
                            numLosses++;
                            System.out.println("You lose!");
                        }
                        numGames++;

                        // Return to menu or restart
                        System.out.println("\nChoose an option:");
                        System.out.println("[1] Play again");
                        System.out.println("[2] Return to menu");

                        selection = 0;
                        while(true) {
                            String input = sc.nextLine();
                            try {
                                selection = Integer.parseInt(input);
                            } catch(NumberFormatException ignored) {}

                            if(selection == 1 || selection == 2) {
                                break;
                            }
                            System.out.println("Invalid input: Must be 1 or 2!");
                        }
                        if(selection == 2) {
                            break;
                        }
                    }
                    break;
                case 2: // Stats
                    winPercent = (numGames > 0) ? (float)numWins / numGames * 100.0f : 100.0f;

                    System.out.println("Your stats");
                    System.out.println("Wins: " + numWins);
                    System.out.println("Losses: " + numLosses);
                    System.out.println("Ties: " + numTies);
                    System.out.println("Total Games: " + numGames);
                    System.out.println("Won " + String.format("%.2f", winPercent) + "% of games\n");
                    break;
                case 3: // Exit
                    exit = true;
                    break;
            }
        }

        System.out.println("Thank you for playing Rock Paper Scissors!");
        System.out.println("You won " + numWins + "/" + numGames + " games!");
    }

    public static String getOption(int selection) {
        switch (selection) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Invalid";
        }
    }
}
