package com.ttt.controllers;

import com.ttt.exceptions.InvalidBotCountException;
import com.ttt.models.Game;
import com.ttt.models.Player;
import com.ttt.strategies.winningstrategies.WinningStrategy;

import java.util.List;

public class GameController {
    // Responsible for maintaining and playing with the game
    public Game startGame(int dimension, List<Player> players, int nextPlayerMoveIndex, List<WinningStrategy> winningStrategies) throws InvalidBotCountException {
        Game game = Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setNextPlayerMoveIndex(nextPlayerMoveIndex)
                .setWinningStrategies(winningStrategies)
                .build();

        return game;
    }

    public Player getWinner() {
        return null;
    }

    public void printGame() {

    }

    public void makeMove() {

    }

    public void undo() {

    }
}
