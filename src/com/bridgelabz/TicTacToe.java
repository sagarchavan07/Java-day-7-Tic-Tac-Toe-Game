package com.bridgelabz;

import java.util.Scanner;

public class TicTacToe {
    static char player1letter=' ';
    static char player2letter=' ';
    static Scanner scanner=new Scanner(System.in);
    static char []board=new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',};

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game");
        
        player1letter=chooseLetter();
        player2letter=(player1letter == 'O') ? 'X': 'O';

        System.out.println("player1letter = "+player1letter);
        System.out.println("player2letter = "+player2letter);

        showBoard();

        userMove();

        showBoard();
    }

    static char chooseLetter(){
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
        System.out.println();
    }

    static void userMove(){
        System.out.println("select position on board (1 to 9)");
        int position=scanner.nextInt();

        if (board[position] == ' ') {
            board[position] =player1letter;
        }else {
            while (board[position] != ' '){
                System.out.println(position+ " is already taken");
                position=scanner.nextInt();
            }
            board[position] =player1letter;
        }
    }
}
