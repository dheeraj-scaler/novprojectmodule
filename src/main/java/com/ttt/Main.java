package com.ttt;

import com.ttt.controllers.GameController;
import com.ttt.exceptions.InvalidBotCountException;
import com.ttt.models.*;
import com.ttt.strategies.winningstrategies.ColWinningStrategy;
import com.ttt.strategies.winningstrategies.DiagonalWinningStrategy;
import com.ttt.strategies.winningstrategies.RowWinningStrategy;
import com.ttt.strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

// this is the client class
public class Main {

    public static void main(String[] args) throws InvalidBotCountException {
        int dimension = 3;
        List<Player> players = new ArrayList<>();
        players.add(new Player("Tanishq", 1, new Symbol('X'), PlayerType.HUMAN));
        players.add(new Player("Dheeraj", 2, new Symbol('Y'), PlayerType.HUMAN));

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        int nextPlayerMoveIndex = 0;

        GameController gameController = new GameController();
        Game game = gameController.startGame(dimension, players, nextPlayerMoveIndex, winningStrategies);


        while(game.getGameState().equals(GameState.INPROGRESS)) {
            // Print the board
            // Make a move
            // next player change
        }

    }
}
