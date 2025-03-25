package com.ttt.models;

import com.ttt.factory.BotPlayingStrategyFactory;
import com.ttt.strategies.botplayingstrategies.BotPlayingStrategy;

public class Bot extends Player {

    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, int id, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(name, id, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        // client is passing this botDifficultyLevel
        // We will use factory DP as it helps us create object of the underlying class basis the user input
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        Move move = botPlayingStrategy.makeMove(board);
        // because in the strategy this field was null
        move.setPlayer(this);
        return move;
    }
}
