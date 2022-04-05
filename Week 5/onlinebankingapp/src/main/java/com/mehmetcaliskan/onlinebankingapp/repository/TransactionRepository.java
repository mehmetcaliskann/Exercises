package com.mehmetcaliskan.onlinebankingapp.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mehmetcaliskan.onlinebankingapp.entity.Transaction;
import com.mehmetcaliskan.onlinebankingapp.util.LocalDateTimeAdapter;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Repository
@Getter
public class TransactionRepository {
    List<Transaction> transactions;

    @PostConstruct
    private void init() throws FileNotFoundException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();

        transactions = new LinkedList<>(Arrays.asList(gson.fromJson(new FileReader("src/main/resources/transactions.json"), Transaction[].class)));
    }

    public boolean save(Transaction transaction) {
        transactions.add(transaction);
        return updateFile();
    }

    private boolean updateFile() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();

        try (FileWriter writer = new FileWriter("src/main/resources/transactions.json")) {
            gson.toJson(transactions, writer);
            writer.flush();
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred while writing the transactions.json file.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
        return updateFile();
    }
}
