package com.bridgelabz;

import java.util.Scanner;

public class TicTacToe {
    static char []board=new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',};
    public static void main(String[] args) {
        char player1letter=' ';
        char player2letter=' ';

        System.out.println("Welcome to Tic Tac Toe Game");



        player1letter=chooseLetter();
        player2letter=(player1letter == 'O') ? 'X': 'O';

        System.out.println("player1letter = "+player1letter);
        System.out.println("player2letter = "+player2letter);

        showBoard();


    }

    static char chooseLetter(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("choose letter : O or X");
        return scanner.next().charAt(0);
    }
    static void showBoard(){
        System.out.println("showing board :");
        for (int i = 1; i < 10; i++) {
            System.out.print(board[i]+" ");
            if (i == 3 || i==6) {
                System.out.println();
            }
        }
    }
}
