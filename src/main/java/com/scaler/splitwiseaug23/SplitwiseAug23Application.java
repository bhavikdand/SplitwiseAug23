package com.scaler.splitwiseaug23;

import com.scaler.splitwiseaug23.commands.Command;
import com.scaler.splitwiseaug23.commands.CommandRegistry;
import com.scaler.splitwiseaug23.exceptions.InvalidCommandException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class SplitwiseAug23Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseAug23Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Awaiting input");
            String input = scanner.nextLine();
            Optional<Command> optionalCommand = CommandRegistry.getInstance().get(input);
            if(optionalCommand.isEmpty()){
                System.out.println("Invalid command, please try again");
                continue;
            }
            Command command = optionalCommand.get();
            try {
                command.validateAndExecute(input);
            } catch (InvalidCommandException e){
                System.out.println("Caught invalid command exception, " + e.getMessage());
            }
        }

    }
}
