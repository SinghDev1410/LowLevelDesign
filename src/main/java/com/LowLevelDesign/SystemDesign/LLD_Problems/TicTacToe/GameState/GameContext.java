package com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.GameState;

import com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.Utility.Player;

public class GameContext {
    private GameState currentState;

    public GameContext(){
        currentState = new XturnState();
    }

    public void setState(GameState state){
        this.currentState = state;
    }

    public void next(Player player, boolean hasWon){
        currentState.next(this, player,hasWon);
    }

    public boolean isGameOver(){
        return currentState.isGameOver();
    }

    public GameState getCurrentState(){
        return currentState;
    }
}
