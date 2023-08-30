package com.scaler.splitwiseaug23.controllers;

import com.scaler.splitwiseaug23.dtos.Response;
import com.scaler.splitwiseaug23.dtos.ResponseStatus;
import com.scaler.splitwiseaug23.dtos.SettleGroupRequestDto;
import com.scaler.splitwiseaug23.dtos.SettleGroupResponseDto;
import com.scaler.splitwiseaug23.models.Transaction;
import com.scaler.splitwiseaug23.services.SettleUpService;
import com.scaler.splitwiseaug23.services.SettleUpServiceImpl;

import java.util.List;

public class SettleUpController {

    public SettleUpService settleUpService;


    public SettleGroupResponseDto settleGroup(SettleGroupRequestDto dto){
        List<Transaction> transactions = settleUpService.settleGroup(dto.getGroupId());
        SettleGroupResponseDto responseDto = new SettleGroupResponseDto();
        responseDto.setTransactions(transactions);
        Response response = new Response();
        response.setMessage("Success");
        response.setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setResponse(response);
        return responseDto;
    }

    public List<Transaction> settleUser(int userId){
        List<Transaction> transactions = settleUpService.settleUser(userId);
        return transactions;
    }
}
