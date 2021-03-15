package by.dzikovskiy.userservice.service;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class UserEmailValidatorTest {

    @Test
    public void testValidateEmail() {
        assertTrue(UserEmailValidator.validateEmail("vtrw@mail.ru"));
        assertTrue(!UserEmailValidator.validateEmail("vtrw@mail..ru"));
    }
}