package com.scaler.splitwiseaug23.commands;

import com.scaler.splitwiseaug23.controllers.UserController;
import com.scaler.splitwiseaug23.dtos.RegisterUserRequestDto;
import com.scaler.splitwiseaug23.dtos.RegisterUserResponseDto;
import com.scaler.splitwiseaug23.exceptions.InvalidCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class RegisterUserCommand extends Command{
    public static final String REGISTER_USER_COMMAND = "Register";

    private UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController){
        CommandRegistry.getInstance().register(REGISTER_USER_COMMAND, this);
        System.out.println("Inside register user command");
        this.userController = userController;
    }

    @Override
    public void validate(String input) throws InvalidCommandException {
        if(StringUtils.isEmpty(input)){
            throw new InvalidCommandException("Register command cannot be empty/null");
        }
        String[] splits = input.split(" ");
        if(!splits[0].equals("Register")){
            throw new InvalidCommandException("Not as per syntax");
        }

        if(splits.length != 4){
            throw new InvalidCommandException("Length mismatch");
        }

        //TODO validate phone number
    }


    @Override
    public void execute(String input) {
        String[] splits = input.split(" ");
        String userName = splits[1];
        String phoneNum = splits[2];
        String password = splits[3];

        RegisterUserRequestDto dto = new RegisterUserRequestDto();
        dto.setPassword(password);
        dto.setUserName(userName);
        dto.setPhoneNumber(phoneNum);

        RegisterUserResponseDto registerUserResponseDto = userController.registerUser(dto);
        System.out.println(registerUserResponseDto.toString());

    }
}
