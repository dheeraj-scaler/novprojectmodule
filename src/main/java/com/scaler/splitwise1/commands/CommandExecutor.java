package com.scaler.splitwise1.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command c) {
        commands.add(c);
    }

    public void removeCommand(Command c) {
        commands.remove(c);
    }

    public void execute(String input) {
        for(Command command: commands) {
            if(command.matches(input)) {
                command.execute(input);
                break;
            }
        }
    }
}
