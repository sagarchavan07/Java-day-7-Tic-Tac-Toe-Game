package com.bridgelabz;

import java.util.Scanner;

public class TicTacToe {
    public enum Winner{
        PLAYER1,COMPUTER
    }
    static Winner currentPlayer;
    static Winner winner;
    static char playerSymbol;
    static char computerSymbol;
    static int moveCount;
    static Scanner scanner=new Scanner(System.in);
    static char []board=new char[10];

    public static void main(String[] args) throws InterruptedException {
        int position;
        System.out.println("Welcome to Tic Tac Toe Game");
        
        playerSymbol =chooseLetter();
        computerSymbol =(playerSymbol == 'O') ? 'X': 'O';

        System.out.println("player-letter = "+ playerSymbol);
        System.out.println("computer-Letter = "+ computerSymbol);

        currentPlayer=doToss();
        initializeBoard();
        showBoard();

       while (winner == null && moveCount<9){
           if (currentPlayer == Winner.PLAYER1) {
               System.out.println("your turn select position");
               position=scanner.nextInt();
               selectPosition(position, playerSymbol);
           }else {
               System.out.println("computer turn");
               Thread.sleep(1000);
               position= getPosition();
               selectPosition(position, computerSymbol);
           }
           showBoard();
           winner=checkWinner();

           //switch current player
           currentPlayer=(currentPlayer == Winner.PLAYER1) ? Winner.COMPUTER : Winner.PLAYER1;
           moveCount++;

           if (winner == Winner.PLAYER1) {
               System.out.println("Congratulaions...\nyou won the game");
               System.out.println("1.Play again \n2.Exit");
               resetBoard(scanner.nextInt());
           }else if (winner == Winner.COMPUTER) {
               System.out.println("you lost the game");
               System.out.println("1.Play again \n2.Exit");
               resetBoard(scanner.nextInt());
           }else if (moveCount == 9 && winner== null) {
               System.out.println("Match is draw ");
               System.out.println("1.Play again \n2.Exit");
               int playOption=scanner.nextInt();
               resetBoard(playOption);

           }
       }
    }
    static char chooseLetter(){
        char letter=' ';
        while (letter != 'O' && letter != 'X'){
            System.out.println("choose letter : O or X");
            letter= scanner.next().toUpperCase().charAt(0);
        }
        return letter;
    }
    static void showBoard(){
        System.out.println(board[1]+" | "+board[2]+" | "+board[3]);
        System.out.println(board[4]+" | "+board[5]+" | "+board[6]);
        System.out.println(board[7]+" | "+board[8]+" | "+board[9]);
    }
    static void selectPosition(int number, char letter){
        int position=number;

        if (board[position] == ' ') {
            board[position] =letter;
        }else {
            while (board[position] != ' '){
                if (currentPlayer == Winner.PLAYER1) {
                    System.out.println(position+ " is already taken");
                    position=scanner.nextInt();
                }else {
                    position=(int) ((Math.random()*10+1)%9);
                }
            }
            board[position] =letter;
        }
    }
    static Winner doToss(){
        if( ((int)(Math.random()*10)%2)+1 == 1){
            System.out.println("user won the toss");
            return Winner.PLAYER1;
        }else{
            System.out.println("computer won the toss");
            return Winner.COMPUTER;
        }
    }
    static void initializeBoard(){
        for (int i = 0; i < board.length; i++) {
            board[i]=' ';
        }
    }
    static void resetBoard(int x){
        if (x == 1) {               //1. play again
            initializeBoard();
            winner=null;
            moveCount=0;
            currentPlayer=doToss();
            showBoard();

        }
    }
    static Winner checkWinner(){
        if (board[1] == board[2] && board[2] == board[3] && board[2] !=' ') {
            return  (board[1] == playerSymbol) ? Winner.PLAYER1 : Winner.COMPUTER;
        } else if (board[4] == board[5] && board[5] == board[6] && board[5] !=' ') {
            return  (board[4] == playerSymbol) ? Winner.PLAYER1 : Winner.COMPUTER;
        } else if (board[7] == board[8] && board[8] == board[9] && board[8] !=' ') {
            return  (board[7] == playerSymbol) ? Winner.PLAYER1 : Winner.COMPUTER;
        } else if (board[1] == board[4] && board[4] == board[7] && board[4] !=' ') {
            return  (board[1] == playerSymbol) ? Winner.PLAYER1 : Winner.COMPUTER;
        } else if (board[2] == board[5] && board[5] == board[8] && board[5] !=' ') {
            return  (board[2] == playerSymbol) ? Winner.PLAYER1 : Winner.COMPUTER;
        } else if (board[3] == board[6] && board[6] == board[9] && board[6] !=' ') {
            return  (board[3] == playerSymbol) ? Winner.PLAYER1 : Winner.COMPUTER;
        } else if (board[1] == board[5] && board[5] == board[9] && board[5] !=' ') {
            return  (board[1] == playerSymbol) ? Winner.PLAYER1 : Winner.COMPUTER;
        } else if (board[3] == board[5] && board[5] == board[7] && board[5] !=' ') {
            return  (board[3] == playerSymbol) ? Winner.PLAYER1 : Winner.COMPUTER;
        }else return null;
    }
    static int getCornerPosition(){
        int position=0;
        while (board[position] != ' ' || position==0){
            int []corners=new int[]{1,3,7,9};
            int i=(int)(Math.random()*10)%4;
            position= corners[i];
        }
        return position;
    }
    static int getPosition(){
        if ( board[1]==' ' && board[2]== computerSymbol && board[2] == board[3]
                || board[1]==' ' && board[4]== computerSymbol && board[4] == board[7]
                || board[1]==' ' && board[5]== computerSymbol && board[5] == board[9]) {
            return 1;
        } else if (board[2]==' ' && board[1]== computerSymbol && board[1] == board[3]
                || board[2]==' ' && board[5]== computerSymbol && board[5] == board[8]) {
            return 2;
        } else if (board[3]==' ' && board[1]== computerSymbol && board[1] == board[2]
                || board[3]==' ' && board[6]== computerSymbol && board[6] == board[9]
                || board[3]==' ' && board[5]== computerSymbol && board[5] == board[7]) {
            return 3;
        } else if (board[4]==' ' && board[1]== computerSymbol && board[1] == board[7]
                || board[4]==' ' && board[5]== computerSymbol && board[5] == board[6]) {
            return 4;
        } else if (board[5]==' ' && board[1]== computerSymbol && board[1] == board[9]
                || board[5]==' ' && board[2]== computerSymbol && board[2] == board[8]
                || board[5]==' ' && board[3]== computerSymbol && board[3] == board[7]
                || board[5]==' ' && board[4]== computerSymbol && board[4] == board[6]) {
            return 5;
        } else if (board[6]==' ' && board[3]== computerSymbol && board[3] == board[9]
                || board[6]==' ' && board[4]== computerSymbol && board[4] == board[5]) {
            return 6;
        } else if (board[7]==' ' && board[1]== computerSymbol && board[1] == board[4]
                || board[7]==' ' && board[8]== computerSymbol && board[8] == board[9]
                || board[7]==' ' && board[5]== computerSymbol && board[5] == board[3]) {
            return 7;
        } else if (board[8]==' ' && board[2]== computerSymbol && board[2] == board[5]
                || board[8]==' ' && board[7]== computerSymbol && board[7] == board[9]) {
            return 8;
        } else if (board[9]==' ' && board[1]== computerSymbol && board[1] == board[5]
                || board[9]==' ' && board[3]== computerSymbol && board[3] == board[6]
                || board[9]==' ' && board[7]== computerSymbol && board[7] == board[8]) {
            return 9;
        }else if ( board[1]==' ' && board[2] == board[3] && board[3]!=' '
                || board[1]==' ' && board[4] == board[7] && board[7]!=' '
                || board[1]==' ' && board[5] == board[9] && board[9]!=' ') {
            return 1;
        } else if (board[2]==' ' && board[1] == board[3]  && board[3]!=' '
                || board[2]==' ' && board[5] == board[8]  && board[8]!=' ') {
            return 2;
        } else if (board[3]==' ' && board[1] == board[2]  && board[2]!=' '
                || board[3]==' ' && board[6] == board[9] && board[9]!=' '
                || board[3]==' ' && board[5] == board[7] && board[7]!=' ') {
            return 3;
        } else if (board[4]==' ' && board[1] == board[7] && board[7]!=' '
                || board[4]==' ' && board[5] == board[6] && board[6]!=' ') {
            return 4;
        } else if (board[5]==' ' && board[1] == board[9] && board[9]!=' '
                || board[5]==' ' && board[2] == board[8] && board[8]!=' '
                || board[5]==' ' && board[3] == board[7] && board[7]!=' '
                || board[5]==' ' && board[4] == board[6] && board[6]!=' ') {
            return 5;
        } else if (board[6]==' ' && board[3] == board[9] && board[9]!=' '
                || board[6]==' ' && board[4] == board[5] && board[5]!=' ') {
            return 6;
        } else if (board[7]==' ' && board[1] == board[4] && board[4]!=' '
                || board[7]==' ' && board[8] == board[9] && board[9]!=' '
                || board[7]==' ' && board[5] == board[3] && board[3]!=' ') {
            return 7;
        } else if (board[8]==' ' && board[2] == board[5] && board[5]!=' '
                || board[8]==' ' && board[7] == board[9] && board[9]!=' ') {
            return 8;
        } else if (board[9]==' ' && board[1] == board[5] && board[5]!=' '
                || board[9]==' ' && board[3] == board[6] && board[6]!=' '
                || board[9]==' ' && board[7] == board[8] && board[8]!=' ') {
            return 9;
        }else {
            return getCornerPosition();
        }
    }
}
