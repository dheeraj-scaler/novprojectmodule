package com.ttt.factory;

import com.ttt.models.BotDifficultyLevel;
import com.ttt.strategies.botplayingstrategies.BotPlayingStrategy;
import com.ttt.strategies.botplayingstrategies.EasyBotPlayingStrategy;
import com.ttt.strategies.botplayingstrategies.HardBotPlayingStrategy;
import com.ttt.strategies.botplayingstrategies.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        // basis the user input, create an object of the underlying class
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)) {
            return new EasyBotPlayingStrategy();
        } else if(botDifficultyLevel.equals(BotDifficultyLevel.HARD)) {
            return new HardBotPlayingStrategy();
        } else if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)) {
            return new MediumBotPlayingStrategy();
        }
        return null;
    }
}
