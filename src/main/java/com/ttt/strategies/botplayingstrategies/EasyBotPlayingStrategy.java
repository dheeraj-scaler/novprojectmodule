package com.ttt.strategies.botplayingstrategies;

import com.ttt.models.Board;
import com.ttt.models.Cell;
import com.ttt.models.CellState;
import com.ttt.models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row: board.getBoard()) {
            for (Cell cell: row) {
                if(cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(null, cell);
                }
            }
        }

        return null;
    }
}
