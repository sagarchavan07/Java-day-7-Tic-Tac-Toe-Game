package com.bridgelabz;

import java.util.Scanner;

public class TicTacToe {
    static final int PLAYER_1=1;    //user
    static final int PLAYER_2=2;    //computer
    static int currentPlayer;
    static int winner;
    static char player1letter=' ';
    static char player2letter=' ';
    static Scanner scanner=new Scanner(System.in);
    static char []board=new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',};

    public static void main(String[] args) throws InterruptedException {
        int position;
        System.out.println("Welcome to Tic Tac Toe Game");
        
        player1letter=chooseLetter();
        player2letter=(player1letter == 'O') ? 'X': 'O';

        System.out.println("player1letter = "+player1letter);
        System.out.println("player2letter = "+player2letter);

        currentPlayer=doToss();
        showBoard();

       while (winner == 0){
           if (currentPlayer == PLAYER_1) {
               System.out.println("your turn select position");
               position=scanner.nextInt();
               selectPosition(position,player1letter);
           }else {
               System.out.println("computer turn");
               Thread.sleep(1000);
               position= (int) ((Math.random()*10+1)%9);
               selectPosition(position,player2letter);
           }
           showBoard();
           winner=checkWinner();

           //switch current player
           currentPlayer=(currentPlayer == PLAYER_1) ? PLAYER_2 : PLAYER_1;

       }
        if (winner == PLAYER_1) {
            System.out.println("Congratulaions...\nyou won the game");
        }else {
            System.out.println("you lost the game");
        }
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

    static void selectPosition(int number, char letter){
        int position=number;

        if (board[position] == ' ') {
            board[position] =letter;
        }else {
            while (board[position] != ' '){
                if (currentPlayer == PLAYER_1) {
                    System.out.println(position+ " is already taken");
                    position=scanner.nextInt();
                }else {
                    position= (int) ((Math.random()*10+1)%9);
                }

            }
            board[position] =letter;
        }
    }
    static int doToss(){
        if((Math.random()*10)%2 ==1){
            System.out.println("user won the toss");
            return PLAYER_1;
        }else{
            System.out.println("computer won the toss");
            return PLAYER_2;
        }
    }

    static int checkWinner(){
        if (board[1] == board[2] && board[2] == board[3] && board[2] !=' ') {
            return  (board[1] == player1letter) ? PLAYER_1 : PLAYER_2;
        } else if (board[4] == board[5] && board[5] == board[6] && board[5] !=' ') {
            return  (board[4] == player1letter) ? PLAYER_1 : PLAYER_2;
        } else if (board[7] == board[8] && board[8] == board[9] && board[8] !=' ') {
            return  (board[7] == player1letter) ? PLAYER_1 : PLAYER_2;
        } else if (board[1] == board[4] && board[4] == board[7] && board[4] !=' ') {
            return  (board[1] == player1letter) ? PLAYER_1 : PLAYER_2;
        } else if (board[2] == board[5] && board[5] == board[8] && board[5] !=' ') {
            return  (board[2] == player1letter) ? PLAYER_1 : PLAYER_2;
        } else if (board[3] == board[6] && board[6] == board[9] && board[6] !=' ') {
            return  (board[3] == player1letter) ? PLAYER_1 : PLAYER_2;
        } else if (board[1] == board[5] && board[5] == board[9] && board[5] !=' ') {
            return  (board[1] == player1letter) ? PLAYER_1 : PLAYER_2;
        } else if (board[3] == board[5] && board[5] == board[7] && board[5] !=' ') {
            return  (board[3] == player1letter) ? PLAYER_1 : PLAYER_2;
        }else return 0;
    }
}
