package exceptions;

public class InvalidAuthenticationException extends Exception {
    public InvalidAuthenticationException() {
        super("Credentials are wrong! Login failed.");
    }
}
