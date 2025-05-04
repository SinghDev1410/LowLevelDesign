package com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.PlayerStrategies;

import com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.Utility.Board;
import com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.Utility.Position;

public interface PlayerStrategies {

    Position makeMove(Board board);
}
