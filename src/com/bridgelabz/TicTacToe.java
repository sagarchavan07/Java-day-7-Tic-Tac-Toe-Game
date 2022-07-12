package com.bridgelabz;

import java.util.Scanner;

public class TicTacToe {
    static final int PLAYER_1=0;    //user
    static final int PLAYER_2=1;    //computer
    static int currentPlayer;
    static char player1letter=' ';
    static char player2letter=' ';
    static Scanner scanner=new Scanner(System.in);
    static char []board=new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',};

    public static void main(String[] args) {
        int position;
        System.out.println("Welcome to Tic Tac Toe Game");
        
        player1letter=chooseLetter();
        player2letter=(player1letter == 'O') ? 'X': 'O';

        System.out.println("player1letter = "+player1letter);
        System.out.println("player2letter = "+player2letter);

        currentPlayer=doToss();
        showBoard();

        if (currentPlayer == PLAYER_1) {
            System.out.println("user won the toss");
            System.out.println("select position on board (1 to 9)");
            position=scanner.nextInt();
        }else {
            System.out.println("computer won the toss");
            position= (int) ((Math.random()*10+1)%9);
        }

        selectPosition(position);

        showBoard();
    }

    static char chooseLetter(){
        System.out.println("choose letter : O or X");
        return scanner.next().toUpperCase().charAt(0);
    }
    static void showBoard(){
        System.out.println("showing board :");
        for (int i = 1; i < 10; i++) {
            System.out.print(board[i]+" .");
            if (i == 3 || i==6) {
                System.out.println();
            }
        }
        System.out.println();
    }

    static void selectPosition(int number){
        int position=number;

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
    static int doToss(){
        if((Math.random()*10)%2 ==1){
            return PLAYER_1;
        }else{
            return PLAYER_2;
        }
    }
}
