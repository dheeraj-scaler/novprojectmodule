package com.ttt.models;

import com.ttt.exceptions.InvalidBotCountException;
import com.ttt.strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players;
    List<Move> moves;
    private Board board;
    private Player winner;
    private GameState gameState;
    private int nextPlayerMoveIndex;
    List<WinningStrategy> winningStrategies;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    private Game(int dimension, List<Player> players,int nextPlayerMoveIndex, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.moves = new ArrayList<>();
        this.board = new Board(dimension);
        this.winner = null;
        this.gameState = GameState.INPROGRESS;
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
        this.winningStrategies = winningStrategies;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int dimension;
        private List<Player> players;
        private int nextPlayerMoveIndex;
        List<WinningStrategy> winningStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
            this.nextPlayerMoveIndex = nextPlayerMoveIndex;
            return this;
        }


        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        private void checkBotCount() throws InvalidBotCountException {
            int botCount = 0;
            for(Player player : players) {
                if(player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
            }

            if(botCount > 1) {
                // throw exception
                throw new InvalidBotCountException("Bot count should not be more than 1");
            }
        }

        private void validate() throws InvalidBotCountException {
            // bot count
            checkBotCount();
        }
        // HW1 : Implement the other validation



        public Game build() throws InvalidBotCountException {
            // validate first
            // bot count
            // player count
            // unique player symbol
            validate();

            return new Game(dimension, players, nextPlayerMoveIndex, winningStrategies);
        }
    }
}
