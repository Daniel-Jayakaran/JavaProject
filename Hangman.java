package practice;

import java.util.*;

public class Hangman {

    static String[] words = {
        "java", "hangman", "programming", "computer", "school",
        "elephant", "guitar", "engineer", "keyboard", "mouse"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String word = words[rand.nextInt(words.length)];
        char[] guessed = new char[word.length()];
        Arrays.fill(guessed, '_');

        int chances = 7;
        ArrayList<Character> usedLetters = new ArrayList<>();

        System.out.println("===== HANGMAN GAME =====");

        while (chances > 0) {
            System.out.println("\nWord: " + String.valueOf(guessed));
            System.out.println("Chances Left: " + chances);
            System.out.println("Used letters: " + usedLetters);

            System.out.print("Enter a letter: ");
            char guess = sc.next().toLowerCase().charAt(0);

            if (usedLetters.contains(guess)) {
                System.out.println("You already guessed this letter!");
                continue;
            }

            usedLetters.add(guess);

            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessed[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                chances--;
                System.out.println("Wrong guess!");
            } else {
                System.out.println("Good guess!");
            }

            // Check win
            if (String.valueOf(guessed).equals(word)) {
                System.out.println("\n🎉 YOU WON! 🎉");
                System.out.println("The word was: " + word);
                return;
            }
        }

        // If out of chances
        System.out.println("\n💀 GAME OVER!");
        System.out.println("The correct word was: " + word);
    }
}
