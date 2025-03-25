package com.ttt.strategies.winningstrategies;

import com.ttt.models.Board;
import com.ttt.models.Move;

public interface WinningStrategy {

    boolean checkWinner(Board board, Move move);
}
