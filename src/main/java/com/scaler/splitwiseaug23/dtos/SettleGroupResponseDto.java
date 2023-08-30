package com.scaler.splitwiseaug23.dtos;

import com.scaler.splitwiseaug23.models.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class SettleGroupResponseDto {
    private List<Transaction> transactions;
    private Response response;
}
