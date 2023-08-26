package com.scaler.splitwiseaug23.commands;

import com.scaler.splitwiseaug23.exceptions.InvalidCommandException;

public abstract class Command {

    public void validateAndExecute(String input) throws InvalidCommandException{
        validate(input);
        execute(input);
    }

    public abstract void validate(String input) throws InvalidCommandException;

    public abstract void execute(String input);
}
