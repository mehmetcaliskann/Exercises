package com.mehmetcaliskan.onlinebankingapp.service;

import com.mehmetcaliskan.onlinebankingapp.entity.Transaction;
import com.mehmetcaliskan.onlinebankingapp.entity.User;
import com.mehmetcaliskan.onlinebankingapp.repository.TransactionRepository;
import com.mehmetcaliskan.onlinebankingapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public boolean performTransaction(Transaction transaction) {
        User sender = userRepository.getUserByTcKimlikNo(transaction.getSenderTcKimlikNo());
        User receiver = userRepository.getUserByTcKimlikNo(transaction.getReceiverTcKimlikNo());

        if (transaction.isValid(sender.getBalance())) {
            sender.setBalance(sender.getBalance().subtract(transaction.getAmount()));
            receiver.setBalance(receiver.getBalance().add(transaction.getAmount()));
            transaction.setPerformedAt(LocalDateTime.now());

            userRepository.save(sender);
            userRepository.save(receiver);
            transactionRepository.save(transaction);
            return true;
        } else {
            System.out.println("Transaction failed");
            return false;
        }
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.getTransactions();
    }
}
