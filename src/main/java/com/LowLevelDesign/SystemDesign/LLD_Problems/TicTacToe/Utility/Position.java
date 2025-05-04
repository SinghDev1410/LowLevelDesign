package com.LowLevelDesign.SystemDesign.LLD_Problems.TicTacToe.Utility;

public class Position {
    public int row;
    public int col;

    public Position(int row , int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString(){
        return "(" + row + ", " + col + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj ) return true;
        if(!(obj instanceof Position)) return false;
        Position other = (Position) obj;
        return this.row == other.row && this.col == other.col;

    }

    @Override
    public int hashCode() {
        return 31 * row + col;
    }
}
