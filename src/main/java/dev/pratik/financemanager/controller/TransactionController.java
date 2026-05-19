package dev.pratik.financemanager.controller;

import dev.pratik.financemanager.model.Transaction;
import dev.pratik.financemanager.model.TransactionType;
import dev.pratik.financemanager.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    // Add transaction
    @PostMapping
    public ResponseEntity<Transaction> addTransaction(
            @RequestBody Transaction transaction) {
        return ResponseEntity.ok(
                transactionService.addTransaction(transaction));
    }

    // Get all transactions
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(
                transactionService.getAllTransactions());
    }

    // Get by type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Transaction>> getByType(
            @PathVariable TransactionType type) {
        return ResponseEntity.ok(
                transactionService.getByType(type));
    }

    // Get by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Transaction>> getByCategory(
            @PathVariable String category) {
        return ResponseEntity.ok(
                transactionService.getByCategory(category));
    }

    // Delete transaction
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(
            @PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok("Transaction deleted successfully");
    }

    // Get total balance
    @GetMapping("/balance")
    public ResponseEntity<Double> getTotalBalance() {
        return ResponseEntity.ok(
                transactionService.getTotalBalance());
    }

    // Get transaction by ID
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                transactionService.getTransactionById(id));
    }

    // Update transaction
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(
            @PathVariable Long id,
            @RequestBody Transaction transaction) {
        return ResponseEntity.ok(
                transactionService.updateTransaction(id, transaction));
    }
}