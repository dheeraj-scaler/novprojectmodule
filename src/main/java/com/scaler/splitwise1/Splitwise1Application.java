package com.scaler.splitwise1;

import com.scaler.splitwise1.commands.CommandExecutor;
import com.scaler.splitwise1.commands.RegisterCommand;
import com.scaler.splitwise1.commands.SettleUpUserCommand;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Splitwise1Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CommandExecutor commandExecutor = new CommandExecutor();

        commandExecutor.addCommand(new RegisterCommand());
        commandExecutor.addCommand(new SettleUpUserCommand());

        while(true) {
            String input = scanner.next();
            commandExecutor.execute(input);
        }

    }

}
