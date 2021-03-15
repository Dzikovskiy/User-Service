package by.dzikovskiy.userservice.service;

public class UserEmailValidator {
    public static boolean validateEmail(String email) {
        return email.matches("^[^@\\s]+@[^@\\s\\.]+\\.[^@\\.\\s]+$");
    }
}
