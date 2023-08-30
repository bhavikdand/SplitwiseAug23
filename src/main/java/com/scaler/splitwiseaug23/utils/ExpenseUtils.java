package com.scaler.splitwiseaug23.utils;

import com.scaler.splitwiseaug23.models.Expense;
import com.scaler.splitwiseaug23.models.ExpenseType;
import com.scaler.splitwiseaug23.models.ExpenseUser;
import com.scaler.splitwiseaug23.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseUtils {

    public static Map<User, Double> aggregateExpenses(List<Expense> expenses){
        Map<User, Double> condensedExpenses = new HashMap<>();
        for (Expense expense : expenses) {
            for (ExpenseUser expenseUser : expense.getExpenseUsers()) {
                User user = expenseUser.getUser();
                double amountForThisExpense = expenseUser.getExpenseType().equals(ExpenseType.PAID) ? 1 : -1 * expenseUser.getAmount();
                condensedExpenses.put(user,  amountForThisExpense + condensedExpenses.getOrDefault(user, 0d));
            }
        }
        return condensedExpenses;
    }
}
