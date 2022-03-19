import controller.AccountManager;
import exceptions.InvalidAuthenticationException;
import model.account.Account;
import view.LoginPanel;

public class Main {

    public static void main(String[] args) {
        Account account;
        AccountManager accountManager = new AccountManager();
        LoginPanel loginPanel = new LoginPanel(accountManager);

        try {
            account = loginPanel.showLoginConsoleAndLogin();
        } catch (InvalidAuthenticationException e) {
            e.printStackTrace();
        }

        System.out.println("Good bye!");
    }
}
