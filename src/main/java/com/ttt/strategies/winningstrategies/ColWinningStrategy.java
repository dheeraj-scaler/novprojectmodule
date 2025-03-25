package com.ttt.strategies.winningstrategies;

import com.ttt.models.Board;
import com.ttt.models.Move;

public class ColWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        // HOW
        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {

    }
}
