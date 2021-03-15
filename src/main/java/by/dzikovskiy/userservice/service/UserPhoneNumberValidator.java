package by.dzikovskiy.userservice.service;

public class UserPhoneNumberValidator {
    public static boolean validateBelarusianNumber(String phoneNumber) {
        return phoneNumber.replace(" ", "").matches("375\\d{9}$");
    }
}
