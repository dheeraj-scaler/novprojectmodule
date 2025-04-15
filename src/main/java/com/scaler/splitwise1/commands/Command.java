package com.scaler.splitwise1.commands;

public interface Command {

    // match user input to comman
    boolean matches(String input);

    void execute(String input);

}
