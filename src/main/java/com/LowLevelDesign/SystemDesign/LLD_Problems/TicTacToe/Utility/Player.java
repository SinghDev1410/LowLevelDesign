package com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.Utility;

import com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.PlayerStrategies.PlayerStrategies;
import com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.Symbol;

public class Player {
    Symbol symbol;
    PlayerStrategies playerStrategies;

        public Player(Symbol symbol, PlayerStrategies playerStrategies){
            this.symbol=symbol;
            this.playerStrategies = playerStrategies;
        }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerStrategies getPlayerStrategies() {
        return playerStrategies;
    }
}
