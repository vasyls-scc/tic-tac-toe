package com.stockcharts.interns.vasyls.tictactoe;

public class GraphicsApp {

    public char[][] b;
    
    public GraphicsApp (int[][] gameBoard) {
        this.b = new char[3][3];
        this.updateBoardGraphics(gameBoard);
        this.printBoard();
    }

    public void updateBoardGraphics(int[][] boardArray) {
        for(int y=0; y<boardArray.length; y++) {
            for(int x=0; x<boardArray[y].length; x++) {
                if (boardArray[y][x] == 1) b[y][x] = 'X';
                else if (boardArray[y][x] == 2) b[y][x] = '○';
                else b[y][x] = '-';
        }
    }
    }

    public void printBoard() { 

        System.out.println("   a     b     c");
        System.out.println("      |     |     ");
        System.out.println("1  "+this.b[0][0]+"  |  "+this.b[0][1]+"  |  "+this.b[0][2]+"  ");
        System.out.println(" _____|_____|_____");
        System.out.println("      |     |     ");
        System.out.println("2  "+this.b[1][0]+"  |  "+this.b[1][1]+"  |  "+this.b[1][2]+"  ");
        System.out.println(" _____|_____|_____");
        System.out.println("      |     |     ");
        System.out.println("3  "+this.b[2][0]+"  |  "+this.b[2][1]+"  |  "+this.b[2][2]+"  ");
        System.out.println("      |     |     ");
        System.out.println("");
    }

    public static void main(String[] args) {
        int[][] gameBoard = new int[3][3];
        GraphicsApp board = new GraphicsApp(gameBoard);
        gameBoard[1][1] = 1;
        board.updateBoardGraphics(gameBoard);
        board.printBoard();

        gameBoard[2][2] = 2;
        board.updateBoardGraphics(gameBoard);
        board.printBoard();

    }

}