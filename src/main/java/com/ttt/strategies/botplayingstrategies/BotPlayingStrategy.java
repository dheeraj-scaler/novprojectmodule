package com.ttt.strategies.botplayingstrategies;

import com.ttt.models.Board;
import com.ttt.models.Move;

public interface BotPlayingStrategy {

    Move makeMove(Board board);
}
