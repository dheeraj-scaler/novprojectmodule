package com.ttt.strategies.winningstrategies;

import com.ttt.models.Board;
import com.ttt.models.Move;
import com.ttt.models.Symbol;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{
    private HashMap<Symbol, Integer> leftDiagonal = new HashMap<>();
    private HashMap<Symbol, Integer> rightDiagonal = new HashMap<>();


    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();

        Symbol symbol = move.getPlayer().getSymbol();

        // here the move has to be in the diagonals
        // else it should not do anything


        if(row == column) {
            // left diagonal
            if(!leftDiagonal.containsKey(symbol)) {
                leftDiagonal.put(symbol, 0);
            }
            leftDiagonal.put(symbol, leftDiagonal.get(symbol) + 1);

            // check winner
            if(leftDiagonal.get(symbol) == board.getDimension()) {
                return true;
            }
        }

        if(row + column == board.getDimension() - 1) {
            if(!rightDiagonal.containsKey(symbol)) {
                rightDiagonal.put(symbol, 0);
            }
            rightDiagonal.put(symbol, rightDiagonal.get(symbol) + 1);

            // check winner
            if(rightDiagonal.get(symbol) == board.getDimension()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();

        if(row == column) {
            // left
            leftDiagonal.put(symbol, leftDiagonal.get(symbol) - 1);
        }

        if(row + column == board.getDimension() - 1) {
            rightDiagonal.put(symbol, rightDiagonal.get(symbol) -1);
        }
    }
}
