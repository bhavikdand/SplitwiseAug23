package com.scaler.splitwiseaug23.services;

import com.scaler.splitwiseaug23.models.Transaction;

import java.util.List;

public interface SettleUpService {
    public List<Transaction> settleGroup(int groupId);

    public List<Transaction> settleUser(int userId);
}
