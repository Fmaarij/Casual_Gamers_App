package be.intecbrussel;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class HangMan {
static int counterHangman = 0;
     String dash;
     String word;
     int lives = 7;



    //static String userInput;
    public void startHangman() throws Exception /* avoiding errors */ {
        counterHangman++;
        //calling the file object
        File dictionary = new File("src/be/intecbrussel/animals.txt");

        //calling the Scanner object
        Scanner textDictionry = new Scanner(dictionary);
        //calling the arraylist object
        ArrayList<String> words = new ArrayList<>();

        //till animal.txt has next line
        while (textDictionry.hasNextLine()) {
            //add all into words array
            words.add(textDictionry.nextLine());
        }

        // getting a random word from the words array and changing them to capital letters
        word = words.get((int) (Math.random() * words.size())).toUpperCase();
        //System.out.println(word);
        dash = new String(new char[word.length()]).replace("\0", "-");

        //calling the scanner object to get user input
        Scanner myScanner = new Scanner(System.in);

        System.out.println("*** HANGMAN GAME ***");
        System.out.println("It is an animal which contains " + word.length() + " letters.");
        System.out.println();

        // while loop starts here
        while (lives > 0 && dash.contains("-")) {
            System.out.println("Guess the letter ");
            System.out.println(dash);
            String userInput = myScanner.next().toUpperCase();
            //Checking if the input is a digit
            if (userInput.length() != 1 || Character.isDigit(userInput.charAt(0))) {
                System.out.println("Symbol,integer or more than 1 letter is not allowed");
                continue;
            }
            hang(userInput);
            drawHangman();
        }
        // while loop ends here

        //Announcing the loser
        if (!(dash.equals(word))) {
            System.out.println("******** You lost, the word was : " + word + " ********");
        }

    }

    //The hang function starts here
    public  void hang(String guess) {
        StringBuilder newDash = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                newDash.append(guess.charAt(0));
            } else if (dash.charAt(i) != '-') {
                newDash.append(word.charAt(i));

            } else {
                newDash.append("-");
            }
        }

        if (dash.equals(newDash.toString())) {
            lives--;
            if (lives == 0 || lives == 1) {
                System.out.println("******** " + lives + " live left! ******** ");
            } else {
                System.out.println("******** " + lives + " lives left! ******** ");
            }

        } else {
            dash = newDash.toString();

            //re-check this part
            if(lives > 0){
                System.out.println("******** Great,you are going good ********");
            }

        }
        if (dash.equals(word)) {
            System.out.println("******** Correct! You won! The word was " + word + " ********");
        }
    }
    //The hang function ends here

    //The 2D funtion starts here
    public  void drawHangman() {
        switch (lives) {
            case 6:
                System.out.println("|----------");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                break;
            case 5:
                System.out.println("|----------");
                System.out.println("|   0");
                System.out.println("|");
                System.out.println("|");
                break;
            case 4:
                System.out.println("|----------");
                System.out.println("|   0");
                System.out.println("|   |");
                System.out.println("|");
                break;
            case 3:
                System.out.println("|----------");
                System.out.println("|   0");
                System.out.println("|  -|");
                System.out.println("|");
                break;
            case 2:
                System.out.println("|----------");
                System.out.println("|   0");
                System.out.println("|  -|-");
                System.out.println("|");
                break;
            case 1:
                System.out.println("|----------");
                System.out.println("|   0");
                System.out.println("|  -|-");
                System.out.println("|  /");
                break;
            case 0:
                System.out.println("|----------");
                System.out.println("|   0");
                System.out.println("|  -|-");
                System.out.println("|  / \\");

        }
    }


}
