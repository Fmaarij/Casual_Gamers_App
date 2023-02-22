package be.intecbrussel;


import java.util.Scanner;

public class Tictac {
    public void startTictac() {
        char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String[] players = new String[2];
        char[] marks = {'X', 'O'};

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.println("Player " + (i + 1) + ", please enter your name:");
            players[i] = sc.nextLine();
        }

        int player = 0;
        while (true) {
            displayBoard(board);
            int choice = getChoice(board, players[player], marks[player]);

            if (board[choice - 1] != 'X' && board[choice - 1] != 'O') {
                board[choice - 1] = marks[player];
                if (isWinner(board, marks[player])) {
                    displayBoard(board);
                    System.out.println(players[player] + " It's a draw!");
                    break;
                }
                if (isDraw(board)) {
                    displayBoard(board);
                    System.out.println("It's a draw!");
                    break;
                }
                player = (player + 1) % 2;
            } else {
                System.out.println("Invalid move, please try again.");
            }
        }
    }

    public static void displayBoard(char[] board) {
        System.out.println("-------------");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + board[i] + " | " + board[i + 1] + " | " + board[i + 2] + " |");
            System.out.println("-------------");
        }
    }

    public static int getChoice(char[] board, String player, char mark) {
        Scanner sc = new Scanner(System.in);
        System.out.println(player + ", please choose a free nr to place your mark (1-9):");
        int choice = sc.nextInt();
        return choice;
    }

    public static boolean isWinner(char[] board, char mark) {
        if ((board[0] == mark && board[1] == mark && board[2] == mark) ||
                (board[3] == mark && board[4] == mark && board[5] == mark) ||
                (board[6] == mark && board[7] == mark && board[8] == mark) ||
                (board[0] == mark && board[3] == mark && board[6] == mark) ||
                (board[1] == mark && board[4] == mark && board[7] == mark) ||
                (board[2] == mark && board[5] == mark && board[8] == mark) ||
                (board[0] == mark && board[4] == mark && board[8] == mark) ||
                (board[2] == mark && board[4] == mark && board[6] == mark)) {
            return true;
        }
        return false;
    }

    public static boolean isDraw(char[] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i] != 'X' && board[i] != 'O') {
                return false;
            }
        }
        return true;
    }
}