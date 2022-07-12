package com.bridgelabz;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char player1letter=' ';
        char player2letter=' ';

        System.out.println("Welcome to Tic Tac Toe Game");

        char []board=new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',};

        player1letter=chooseLetter();
        player2letter=(player1letter == 'O') ? 'X': 'O';

        System.out.println("player1letter = "+player1letter);
        System.out.println("player2letter = "+player2letter);

    }

    static char chooseLetter(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("choose letter : O or X");
        return scanner.next().charAt(0);
    }
}
