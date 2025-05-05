package com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.Utility;

import com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.GameState.GameContext;
import com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.Symbol;

public class Board {
    private final int rows;
    private final int columns;
    private Symbol[][] grid;

    public Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        grid = new Symbol[rows][columns];
        for(int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position pos){
        return pos.row >= 0 && pos.row< rows && pos.col >=0 && pos.col<columns
                && grid[pos.row][pos.col] == Symbol.EMPTY;
    }

    // Allows players to make their moves
    public void makeMove(Position pos, Symbol symbol){
        grid[pos.row][pos.col] = symbol;
    }

    // Determine the current state of the game by checking for
    // Rows, Columns and Diagonals for winning conditions

    public  void checkGameState(GameContext context, Player currentPlayer){

    }

}
