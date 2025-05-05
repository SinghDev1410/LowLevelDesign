package com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.GameState;

import com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.Symbol;
import com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.Utility.Player;

public class OturnState implements GameState{

    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        if(hasWon){
            context.setState(player.getSymbol() == Symbol.X ? new XWonState() : new OWonState());
        }

        context.setState(new XturnState());
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
