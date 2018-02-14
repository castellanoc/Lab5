import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {

        // This a comment for Lab 5 
        boolean newGame = true;
        int numberOfGames = 1;
        int menuChoice = 0;

        int playersHand = 0;
        int playerWins = 0;
        int dealersHand;
        int dealerWins = 0;
        int ties = 0;

        int singleCard;
        String face;

        P1Random rndg = new P1Random();
        Scanner scnr = new Scanner(System.in);

        while (menuChoice != 4){
            if (newGame) {
                newGame = false;
                playersHand = 0;

                System.out.println("START GAME #" + numberOfGames);
                System.out.println("");

                // Deal a card
                singleCard = rndg.nextInt(13) + 1;

                switch (singleCard) {
                    case 1:
                        face = "ACE";
                        playersHand += 1;
                        break;
                    case 11:
                        face = "JACK";
                        playersHand += 10;
                        break;
                    case 12:
                        face = "QUEEN";
                        playersHand += 10;
                        break;
                    case 13:
                        face = "KING";
                        playersHand += 10;
                        break;
                    default:
                        face = Integer.toString(singleCard);
                        playersHand += singleCard;
                }

                System.out.println("Your card is a " + face + "!");
                System.out.println("Your hand is: " + playersHand);
                System.out.println("");
            }

            System.out.println("1. Get another card");
            System.out.println("2. Hold hand");
            System.out.println("3. Print statistics");
            System.out.println("4. Exit");

            System.out.println("");
            System.out.println("Choose an option: ");

            menuChoice = scnr.nextInt();

            if (menuChoice < 1 || menuChoice > 4) {
                System.out.println("Invalid input!");
                System.out.println("Please enter an integer value between 1 and 4.");
                System.out.println("");
            }

            switch (menuChoice) {
                // Get another card
                case 1:
                    singleCard = rndg.nextInt(13) + 1;

                    switch (singleCard) {
                        case 1:
                            face = "ACE";
                            playersHand += 1;
                            break;
                        case 11:
                            face = "JACK";
                            playersHand += 10;
                            break;
                        case 12:
                            face = "QUEEN";
                            playersHand += 10;
                            break;
                        case 13:
                            face = "KING";
                            playersHand += 10;
                            break;
                        default:
                            face = Integer.toString(singleCard);
                            playersHand += singleCard;
                    }

                    System.out.println("Your card is a " + face  + "!");
                    System.out.println("Your hand is: " + playersHand);
                    System.out.println("");

                    if (playersHand == 21) {
                        System.out.println("BLACKJACK! You win!");
                        System.out.println("");

                        playerWins += 1;

                        numberOfGames += 1;
                        newGame = true;
                    } else if (playersHand > 21) {
                        System.out.println("You exceeded 21! You lose.");
                        System.out.println("");

                        dealerWins += 1;

                        numberOfGames += 1;
                        newGame = true;
                    }
                    break;
                // Hold hand
                case 2:
                    dealersHand = rndg.nextInt(11) + 16;

                    System.out.println("Dealer's hand: " + dealersHand);
                    System.out.println("Your hand is: " + playersHand);
                    System.out.println("");

                    if (dealersHand > 21) {
                        System.out.println("You win!");
                        System.out.println("");

                        playerWins += 1;

                    } else if (dealersHand == playersHand) {
                        System.out.println("It's a tie! No one wins!");
                        System.out.println("");

                        ties += 1;

                    } else if (dealersHand > playersHand) {
                        System.out.println("Dealer wins!");
                        System.out.println("");

                        dealerWins += 1;

                    } else if (playersHand > dealersHand) {
                        System.out.println("You wins!");
                        System.out.println("");

                        playerWins += 1;
                    }

                    dealersHand = 0;
                    numberOfGames += 1;
                    newGame = true;
                    break;
                // Print statistics
                case 3:
                    System.out.println("Number of Player wins: " + playerWins);
                    System.out.println(("Number of Dealer wins: " + dealerWins));
                    System.out.println("Number of tie games: " + ties);
                    System.out.println("Total # of games played is: " + (numberOfGames - 1));

                    double percent = (playerWins * 100 / (numberOfGames - 1));
                    System.out.println("Percentage of Player wins: " + percent + "%");
                    System.out.println("");
                    break;
            }
        }
    }
}