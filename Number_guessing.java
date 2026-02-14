package Intership;
import java.util.Random;
import java.util.Scanner;
public class Number_guessing {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Random random = new Random();
            int totalScore = 0;
            int rounds = 3;   // number of rounds
            System.out.println("===== NUMBER GUESSING GAME =====");

            for (int round = 1; round <= rounds; round++) {

                int number = random.nextInt(100) + 1; // 1 to 100
                int attempts = 7;   // maximum attempts
                boolean guessed = false;

                System.out.println("\nRound " + round + " starts!");
                System.out.println("Guess a number between 1 and 100");

                for (int i = 1; i <= attempts; i++) {

                    System.out.print("Attempt " + i + ": ");
                    int guess = sc.nextInt();

                    if (guess == number) {
                        System.out.println(" Correct! You guessed it.");
                        totalScore += (attempts - i + 1) * 10; // scoring logic
                        guessed = true;
                        break;
                    }
                    else if (guess < number) {
                        System.out.println(" Too low!");
                    }
                    else {
                        System.out.println(" Too high!");
                    }
                }

                if (!guessed) {
                    System.out.println(" You lost! The number was: " + number);
                }
            }

            System.out.println("\n===== GAME OVER =====");
            System.out.println("Your Total Score: " + totalScore);

            sc.close();

    }

}

