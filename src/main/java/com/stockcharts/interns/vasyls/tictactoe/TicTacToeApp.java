package com.stockcharts.interns.vasyls.tictactoe;

import java.util.Scanner;

public class TicTacToeApp {

    private int[][] board;
    private boolean gameLive;
    private int currentPlayer;
    private String nextMove;
    private int[] coordinate;
    private String playerOneName;
    private String playerTwoName;
    private String playerAI;
    private GraphicsApp gameBoard;

    private TicTacToeApp () {
        this.board = new int[3][3];
        this.coordinate = new int[2];
        this.gameBoard = new GraphicsApp(this.board);
        this.currentPlayer = 1;
        this.gameLive = true;
    }

    public static void main(String[] args) {
        System.out.println("Lets play tic tac toe!\n");

        TicTacToeApp newGame = new TicTacToeApp();
        newGame.getPlayerNames();

        System.out.println("\n" + newGame.playerOneName + " you are playing as X!");
        System.out.println(newGame.playerTwoName + " you are playing as \u25CB!\n"); //\u25CB! is the ○ symbol

        while (newGame.gameLive) {
            newGame.makeMove();
            newGame.updateBoard();
            newGame.swapPlayer();
            newGame.isGameLive();
        }

        newGame.gameBoard.printBoard();
        

    } 

    private void getPlayerNames() {
        System.out.println("Player one, what is your name?");
        Scanner name = new Scanner(System.in);
        this.playerOneName = name.nextLine();
        System.out.println("\nPlayer two, what is your name?");
        this.playerTwoName = name.nextLine();
    }

    private void announcePlayer() {
        if (this.currentPlayer == 1)
            System.out.println(playerOneName + " it's your turn.");
        else
            System.out.println(playerTwoName + " it's your turn.");
    }

    private void getNextMove() {
        Scanner name = new Scanner(System.in);
        this.nextMove = name.nextLine();
        System.out.println("");;
    }

    private void updateCoordinate() {
        int x = this.nextMove.charAt(0);
        int y = this.nextMove.charAt(1);
        int[] coord = {x-97,y-49}; //subtracting ASCII values of a=97 and 1=49
        this.coordinate = coord;
    }
    
    private boolean isValidMove() {
            if (board[coordinate[1]][coordinate[0]] == 0) return true;
            else return false;
        }

    private void swapPlayer() {
        if (this.currentPlayer == 1) this.currentPlayer = 2;
        else this.currentPlayer = 1;
    }

    private void updateBoard() {
        this.board[this.coordinate[1]][this.coordinate[0]] = this.currentPlayer;
        this.gameBoard.updateBoardGraphics(this.board);
    }

    private void makeMove() {
        this.announcePlayer();
        this.gameBoard.printBoard();
        this.getNextMove();
        this.updateCoordinate();
        while (!this.isValidMove()) {
            System.out.println("Please enter an empty location.");
            this.getNextMove();
            this.updateCoordinate();
        }
    }

    private void isGameLive() {
        if (this.board[0][0] == this.board[0][1] && this.board[0][1] == this.board[0][2] && this.board[0][2] != 0) this.gameLive = false;
        if (this.board[1][0] == this.board[1][1] && this.board[1][1] == this.board[1][2] && this.board[1][2] != 0) this.gameLive = false;
        if (this.board[2][0] == this.board[2][1] && this.board[2][1] == this.board[2][2] && this.board[2][2] != 0) this.gameLive = false;

        if (this.board[0][0] == this.board[1][0] && this.board[1][0] == this.board[2][0] && this.board[2][0] != 0) this.gameLive = false;
        if (this.board[0][1] == this.board[1][1] && this.board[1][1] == this.board[2][1] && this.board[2][1] != 0) this.gameLive = false;
        if (this.board[0][2] == this.board[1][2] && this.board[1][2] == this.board[2][2] && this.board[2][2] != 0) this.gameLive = false;
        
        if (this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2] && this.board[2][2] != 0) this.gameLive = false;
        if (this.board[0][2] == this.board[1][1] && this.board[1][1] == this.board[2][0] && this.board[2][0] != 0) this.gameLive = false;
    }

    private void printWinner() {
        if (this.currentPlayer == 1) System.out.println(playerOneName + " won!");
        else System.out.println(playerOneName + " won!");
    }



        
}

