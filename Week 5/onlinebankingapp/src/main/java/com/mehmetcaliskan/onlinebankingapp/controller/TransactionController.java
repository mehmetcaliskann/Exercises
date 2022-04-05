package com.mehmetcaliskan.onlinebankingapp.controller;

import com.mehmetcaliskan.onlinebankingapp.entity.Transaction;
import com.mehmetcaliskan.onlinebankingapp.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
@Validated
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("")
    public String performTransaction(@Valid @RequestBody Transaction transaction) {
        if (transactionService.performTransaction(transaction)) {
            return "Transaction is successful";
        } else {
            return "Transaction is failed";
        }
    }

    @GetMapping("")
    public List<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }
}
