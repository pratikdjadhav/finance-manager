package dev.pratik.financemanager.service;

import dev.pratik.financemanager.model.Transaction;
import dev.pratik.financemanager.model.TransactionType;
import dev.pratik.financemanager.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    // Add a new transaction
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Get all transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Get by type (INCOME or EXPENSE)
    public List<Transaction> getByType(TransactionType type) {
        return transactionRepository.findByType(type);
    }

    // Get by category
    public List<Transaction> getByCategory(String category) {
        return transactionRepository.findByCategory(category);
    }

    // Delete a transaction
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    // Get total balance
    public Double getTotalBalance() {
        List<Transaction> all = transactionRepository.findAll();
        double income = all.stream()
                .filter(t -> t.getType() == TransactionType.INCOME)
                .mapToDouble(Transaction::getAmount)
                .sum();
        double expense = all.stream()
                .filter(t -> t.getType() == TransactionType.EXPENSE)
                .mapToDouble(Transaction::getAmount)
                .sum();
        return income - expense;
    }
}