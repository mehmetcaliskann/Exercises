package controller;

import exceptions.InvalidAuthenticationException;
import model.account.Account;

import java.util.TreeSet;

public class AccountManager {
    private final TreeSet<Account> accounts;

    public AccountManager() {
        accounts = new TreeSet<>();
    }

    public Account login(final String email, final String password) throws InvalidAuthenticationException {
        Account account = accounts.stream()
                .filter(account1 -> account1.areCredentialsCorrect(email, password))
                .findFirst()
                .orElseThrow(InvalidAuthenticationException::new);

        account.login(email, password);
        return account;
    }
}
