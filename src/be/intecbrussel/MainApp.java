package be.intecbrussel;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("******** Chose your game to play or type 0 to quite ******** ");
        System.out.println("******** Type 1 for BattleShip ******** ");
        System.out.println("******** Type 2 for Hangman ******** ");
        System.out.println("******** Type 3 for Tic Tac Toe ******** ");

        int userInput = myScanner.nextInt();

        while (userInput != 0) {
            //Game 1 BattelShip
            if (userInput == 1) {
                BattleShip battleShipGame = new BattleShip();
                battleShipGame.startBattleShip();
                System.out.println();
                System.out.println("******** Type 1 to play again or 0 to quite ******** ");
                System.out.println("******** Type 2 to play Hangman ******** ");
                System.out.println("******** Type 3 to play Tic Tac Toe ******** ");
                userInput = myScanner.nextInt();
            } else if (userInput == 2) {//game 2 Hangman
                HangMan hangManGame = new HangMan();
                hangManGame.startHangman();
                System.out.println();
                System.out.println("******** Type 2 to play again or 0 to quite ******** ");
                System.out.println("******** Type 1 to play BattleShip ******** ");
                System.out.println("******** Type 3 to play Tic Tac Toe ******** ");
                userInput = myScanner.nextInt();
            } else if (userInput == 3) {//game 3 Tic toe
                Tictac ticTacGame = new Tictac();
                ticTacGame.startTictac();
                System.out.println();
                System.out.println("******** Type 3 to play again or 0 to quite ******** ");
                System.out.println("******** Type 2 to play Hangman ******** ");
                System.out.println("******** Type 1 to play BattleShip ******** ");
                userInput = myScanner.nextInt();
            } else {
                System.out.println("******** " + userInput + " dose not exit! ********");
                break;
            }

        }
        System.out.println("******** Good BYE ******** ");
    }
}
