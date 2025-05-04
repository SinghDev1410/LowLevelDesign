package com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.PlayerStrategies;

import com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.Utility.Board;
import com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.Utility.Position;

import java.util.Scanner;

public class HumanPlayerStrategies implements PlayerStrategies{

    private Scanner scanner;
    private String playerName;

    public HumanPlayerStrategies( String playerName) {
        this.scanner = new Scanner(System.in);
        this.playerName = playerName;
    }

    @Override
    public Position makeMove(Board board){
        while(true){
            System.out.printf("%s, enter your move (row [0-2] and column [0-2]): ", playerName);

            try{
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                Position move = new Position(row,col);
                // Validates the player's input.
                // If the move is valid, returns the position.
                if (board.)
            }
        }


    }
}
