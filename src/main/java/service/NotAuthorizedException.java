package service;

public class NotAuthorizedException extends Throwable {
    public NotAuthorizedException(String s) {
        super((s));
    }
}
