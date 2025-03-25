package com.ttt.models;

import java.util.Scanner;

public class Player {

    private String name;
    private int id;
    private Symbol symbol;
    private PlayerType  playerType;
    private Scanner scanner = new Scanner(System.in);


    public Player(String name, int id, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.id = id;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {
        System.out.println("Please enter the row number");

        int row = scanner.nextInt();
        System.out.println("Please enter the column number");

        int column = scanner.nextInt();
        // HW - 2
        // validations here to check is cell is empty or not
        return new Move(this, new Cell(row, column, CellState.EMPTY));

    }
}

