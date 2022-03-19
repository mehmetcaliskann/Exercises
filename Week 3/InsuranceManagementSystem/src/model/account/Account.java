package model.account;

import controller.AddressManager;
import exceptions.InvalidAuthenticationException;
import model.address.Address;
import model.enums.AuthenticationStatus;
import model.insurance.Insurance;
import model.user.User;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Account implements Comparable<Account> {
    private User user;
    private ArrayList<Insurance> insurances;
    private AuthenticationStatus authenticationStatus;

    public final void showUserInfo() {
        System.out.println(user);
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if (areCredentialsCorrect(email, password)) {
            authenticationStatus = AuthenticationStatus.SUCCESS;
        } else {
            authenticationStatus = AuthenticationStatus.FAIL;
            throw new InvalidAuthenticationException();
        }
    }

    public boolean areCredentialsCorrect(String email, String password) {
        boolean isEmailTrue = user.getEmail().equals(email);
        boolean isPasswordTrue = user.getPassword().equals(password);

        return isEmailTrue && isPasswordTrue;
    }

    public boolean addAddress(Address address) {
        return AddressManager.addAddress(user, address);
    }

    public boolean removeAddress(Address address) {
        return AddressManager.removeAddress(user, address);
    }

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public abstract void addInsurancePolicy();

    @Override
    public int compareTo(Account account) {
        return user.getEmail().compareTo(account.getUser().getEmail());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return user.equals(account.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
