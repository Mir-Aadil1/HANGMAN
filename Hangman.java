
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String word = randomWord();

        char[] placeholders = new char[word.length()];

        Arrays.fill(placeholders, '-');

        int misses = 0 ;

        char[] missedGuesses = new char[6];

        while (misses < 6) {

            clearScreen();
            System.out.println(gallows[misses]);

            System.out.print("Word:    ");
            printPlaceholders(placeholders);
            System.out.println();


            System.out.print("Misses: ");
            printMissedGuesses(missedGuesses);
            System.out.println("\n");

            System.out.print("GuessNextCharacter: ");
            char guess = scan.nextLine().charAt(0);

            if (checkGuess(word, guess)) {
                updatePlaceHolders(word, placeholders, guess);
            } else {
                missedGuesses[misses] = guess;
                misses++;
            }
                clearScreen();
            if (Arrays.equals(placeholders, word.toCharArray())) {
                System.out.print(gallows[misses]);
                System.out.print("\nWord:   ");
                printPlaceholders(placeholders);
                System.out.println("\nGOOD WORK!");
                break;
            }
        }

        if (misses == 6) {
            clearScreen();
            System.out.print(gallows[6]);
            System.out.println("\nRIP!");
            System.out.println("\nThe word was: '" + word + "'");
        }
        scan.close();
        }

    public static String randomWord() {
        int numOfWords = words.length;
        Random random = new Random();

        int chosenWordIndex = random.nextInt(numOfWords);

        return words[chosenWordIndex];

    }

    public static boolean checkGuess(String word, char guess) {
       return word.indexOf(guess) >= 0;
        }

    public static void updatePlaceHolders(String word, char[] placeholders, char guess){

        for(int j = 0 ; j < word.length(); j ++) {
            if (word.charAt(j) == guess) {
                placeholders[j] = guess;
            }
        }

    }

    public static void printPlaceholders(char[] placeholders) {

        for (char placeholder : placeholders) {
            System.out.print(" " + placeholder);
        }
        System.out.println();
    }
public static void printMissedGuesses(char[] misses) {
        for (int i = 0; i < misses.length; i++) {
            if (misses[i] != '\u0000') {
                System.out.print(" " + misses[i]);
            }
        }
    }
    
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) System.out.println();
    }
}


        








