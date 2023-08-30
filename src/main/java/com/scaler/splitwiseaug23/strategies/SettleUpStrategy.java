package com.scaler.splitwiseaug23.strategies;

import com.scaler.splitwiseaug23.models.Transaction;
import com.scaler.splitwiseaug23.models.User;

import java.util.List;
import java.util.Map;

public interface SettleUpStrategy {

    public List<Transaction> settleUp(Map<User, Double> aggregateExpenses);
}
