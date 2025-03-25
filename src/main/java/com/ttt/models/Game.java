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

    public void makeMove() {
        Player currentPlayer = players.get(nextPlayerMoveIndex);

        System.out.println("Current player name is "+ currentPlayer.getName());

        // I will make a move
        Move move = currentPlayer.makeMove(board);

        System.out.println("Player want to make a move at" + move.getCell().getRow() + " " + move.getCell().getColumn());

        // Add a player in the board
        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();

        Cell cellToChange = board.getBoard().get(row).get(column);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellState(CellState.FILLED);

        // maintain the list of moves
        Move finalMoveObject = new Move(currentPlayer, cellToChange);

        moves.add(finalMoveObject);


        // update next player
        nextPlayerMoveIndex += 1;
        nextPlayerMoveIndex %= players.size();

        // you can update the winner
        if(checkWinner(finalMoveObject)) {
            // whether a player is winning or not
            winner = currentPlayer;
            gameState = GameState.ENDED;
        } else if(moves.size() == (board.getDimension() * board.getDimension())) {
            // no valid moves left
            gameState = GameState.DRAW;
        }

    }

    public boolean checkWinner(Move move) {
        for(WinningStrategy winningStrategy: winningStrategies) {
            if(winningStrategy.checkWinner(board, move)) {
                return true;
            }
        }
        return false;
    }

    public void undo() {
        // find the last move
        // remove it
        // cell state should be marked as empty
        // clear all the hashmaps in the winning strategies

        if(moves.isEmpty()) {
            // throw some error
            return;
        }

        Move lastMove = moves.get(moves.size() - 1);
        moves.remove(lastMove);

        Cell cell = lastMove.getCell();
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);

        // chaning the values in the hashmap
        for(WinningStrategy winningStrategy: winningStrategies) {
            winningStrategy.handleUndo(board, lastMove);
        }

        // undo the next Player move index as well
        nextPlayerMoveIndex -= 1;
        nextPlayerMoveIndex = (nextPlayerMoveIndex + players.size()) % players.size();
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
