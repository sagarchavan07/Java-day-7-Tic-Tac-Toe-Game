package com.bridgelabz;

import java.util.Scanner;

public class TicTacToe {
    static final int PLAYER_1=1;    //user
    static final int COMPUTER =2;    //computer
    static int currentPlayer;
    static int winner;
    static char playerLetter =' ';
    static char computerLetter =' ';
    static int moveCount;
    static Scanner scanner=new Scanner(System.in);
    static char []board=new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',};

    public static void main(String[] args) throws InterruptedException {
        int position;
        System.out.println("Welcome to Tic Tac Toe Game");
        
        playerLetter =chooseLetter();
        computerLetter =(playerLetter == 'O') ? 'X': 'O';

        System.out.println("player1letter = "+ playerLetter);
        System.out.println("player2letter = "+ computerLetter);

        currentPlayer=doToss();
        showBoard();

       while (winner == 0 && moveCount<9){
           if (currentPlayer == PLAYER_1) {
               System.out.println("your turn select position");
               position=scanner.nextInt();
               selectPosition(position, playerLetter);
           }else {
               System.out.println("computer turn");
               Thread.sleep(1000);
               position= getPosition();
               selectPosition(position, computerLetter);
           }
           showBoard();
           winner=checkWinner();

           //switch current player
           currentPlayer=(currentPlayer == PLAYER_1) ? COMPUTER : PLAYER_1;
           moveCount++;

           if (moveCount == 9) {
               System.out.println("Match is draw ");
               System.out.println("1.Play again \n2.Exit");
               resetGame(scanner.nextInt());
           }

       }
        if (winner == PLAYER_1) {
            System.out.println("Congratulaions...\nyou won the game");
        }else if (winner == COMPUTER) {
            System.out.println("you lost the game");
        }
    }

    static char chooseLetter(){
        System.out.println("choose letter : O or X");
        return scanner.next().toUpperCase().charAt(0);
    }
    static void showBoard(){
        System.out.println("showing board :");
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
                if (currentPlayer == PLAYER_1) {
                    System.out.println(position+ " is already taken");
                    position=scanner.nextInt();
                }else {
                    position=(int) ((Math.random()*10+1)%9);
                }

            }
            board[position] =letter;
        }
    }
    static int doToss(){
        if( ((int)(Math.random()*10)%2)+1 ==PLAYER_1){
            System.out.println("user won the toss");
            return PLAYER_1;
        }else{
            System.out.println("computer won the toss");
            return COMPUTER;
        }
    }

    static void resetGame(int x){
        if (x == 1) {
            for (int i = 0; i < 10; i++) {
                board[i]=' ';
            }
            winner=0;
            moveCount=0;
        }
    }

    static int checkWinner(){
        if (board[1] == board[2] && board[2] == board[3] && board[2] !=' ') {
            return  (board[1] == playerLetter) ? PLAYER_1 : COMPUTER;
        } else if (board[4] == board[5] && board[5] == board[6] && board[5] !=' ') {
            return  (board[4] == playerLetter) ? PLAYER_1 : COMPUTER;
        } else if (board[7] == board[8] && board[8] == board[9] && board[8] !=' ') {
            return  (board[7] == playerLetter) ? PLAYER_1 : COMPUTER;
        } else if (board[1] == board[4] && board[4] == board[7] && board[4] !=' ') {
            return  (board[1] == playerLetter) ? PLAYER_1 : COMPUTER;
        } else if (board[2] == board[5] && board[5] == board[8] && board[5] !=' ') {
            return  (board[2] == playerLetter) ? PLAYER_1 : COMPUTER;
        } else if (board[3] == board[6] && board[6] == board[9] && board[6] !=' ') {
            return  (board[3] == playerLetter) ? PLAYER_1 : COMPUTER;
        } else if (board[1] == board[5] && board[5] == board[9] && board[5] !=' ') {
            return  (board[1] == playerLetter) ? PLAYER_1 : COMPUTER;
        } else if (board[3] == board[5] && board[5] == board[7] && board[5] !=' ') {
            return  (board[3] == playerLetter) ? PLAYER_1 : COMPUTER;
        }else return 0;
    }

    static int getPosition(){
        if ( board[1]==' ' && board[2]== computerLetter && board[2] == board[3]
                || board[1]==' ' && board[4]== computerLetter && board[4] == board[7]
                || board[1]==' ' && board[5]== computerLetter && board[5] == board[9]) {
            return 1;
        } else if (board[2]==' ' && board[1]== computerLetter && board[1] == board[3]
                || board[2]==' ' && board[5]== computerLetter && board[5] == board[8]) {
            return 2;
        } else if (board[3]==' ' && board[1]== computerLetter && board[1] == board[2]
                || board[3]==' ' && board[6]== computerLetter && board[6] == board[9]
                || board[3]==' ' && board[5]== computerLetter && board[5] == board[7]) {
            return 3;
        } else if (board[4]==' ' && board[1]== computerLetter && board[1] == board[7]
                || board[4]==' ' && board[5]== computerLetter && board[5] == board[6]) {
            return 4;
        } else if (board[5]==' ' && board[1] == computerLetter && board[1] == board[9]
                || board[5]==' ' && board[2] == computerLetter && board[2] == board[8]
                || board[5]==' ' && board[3] == computerLetter && board[3] == board[7]
                || board[5]==' ' && board[4]== computerLetter && board[4] == board[6]) {
            return 5;
        } else if (board[6]==' ' && board[3]== computerLetter && board[3] == board[9]
                || board[6]==' ' && board[4]== computerLetter && board[4] == board[5]) {
            return 6;
        } else if (board[7]==' ' && board[1]== computerLetter && board[1] == board[4]
                || board[7]==' ' && board[8]== computerLetter && board[8] == board[9]
                || board[7]==' ' && board[5]== computerLetter && board[5] == board[3]) {
            return 7;
        } else if (board[8]==' ' && board[2]== computerLetter && board[2] == board[5]
                || board[8]==' ' && board[7]== computerLetter && board[7] == board[9]) {
            return 8;
        } else if (board[9]==' ' && board[1]== computerLetter && board[1] == board[5]
                || board[9]==' ' && board[3]== computerLetter && board[3] == board[6]
                || board[9]==' ' && board[7]== computerLetter && board[7] == board[8]) {
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
        }else
        return  (int) ((Math.random()*10+1)%9);
    }
}
