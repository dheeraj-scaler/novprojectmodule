package com.scaler.splitwise1.service;

import com.scaler.splitwise1.models.Expense;
import com.scaler.splitwise1.models.ExpenseUser;
import com.scaler.splitwise1.models.User;
import com.scaler.splitwise1.repository.ExpenseUserRepository;
import com.scaler.splitwise1.repository.UserRepository;
import com.scaler.splitwise1.strategies.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {

    private UserRepository  userRepository;
    private ExpenseUserRepository expenseUserRepository;

    private SettleUpStrategy settleUpStrategy;

    public SettleUpService(UserRepository userRepository, ExpenseUserRepository expenseUserRepository, SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Expense> settleUpUser(Long userId) {


        /**
         * 1. Get user using userId
         * 2. If no user, throw exception
         * 3. Get all expenses for user from userexpense
         * 4. Iterate through all the expenses and find out
         * who paid more and who paid less
         * 5. Implement the settle up logic
         *  Imp : Filter group expenses
         *
         */

        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty()) {
            // throw exception
        }

        User user1 = user.get();

        List<ExpenseUser> expenseUsers = expenseUserRepository.findByUser(user1);

        Set<Expense> expenses = new HashSet<>();
        for(ExpenseUser expenseUser : expenseUsers) {
            expenses.add(expenseUser.getExpense());
        }

        List<Expense> expenseToSettle = settleUpStrategy.settleUp(expenses.stream().toList());

        List<Expense> expenseToReturn = new ArrayList<>();
        for(Expense expense: expenseToSettle) {
            for(ExpenseUser expenseUser: expense.getExpenseUsers()) {
                if(expenseUser.getUser().equals(user1)) {
                    expenseToReturn.add(expense);
                    break;
                }
            }
        }

        return expenseToReturn;

    }

    public List<Expense> settleUpGroup(Long groupId) {
        List<Expense> expenses = new ArrayList<>();

        return expenses;
    }
}
