package com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.GameState;

import com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.Utility.Player;

public class OWonState implements GameState{
    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        //
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
