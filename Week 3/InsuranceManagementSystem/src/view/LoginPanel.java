package view;

import controller.AccountManager;
import exceptions.InvalidAuthenticationException;
import model.account.Account;

import java.util.Scanner;

public class LoginPanel {
    private final AccountManager accountManager;
    private final Scanner input;

    public LoginPanel(AccountManager accountManager) {
        this.accountManager = accountManager;
        input = new Scanner(System.in);
    }

    public Account showLoginConsoleAndLogin() throws InvalidAuthenticationException {
        String email, password;
        System.out.println("----------------------");
        System.out.print("Enter e-mail: ");
        email = input.nextLine();
        System.out.print("Enter password: ");
        password = input.nextLine();
        System.out.println("----------------------");

        return login(email, password);
    }

    private Account login(String email, String password) throws InvalidAuthenticationException {
        return accountManager.login(email, password);
    }
}
