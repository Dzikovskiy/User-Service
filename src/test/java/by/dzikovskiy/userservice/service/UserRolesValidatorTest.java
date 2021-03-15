package by.dzikovskiy.userservice.service;

import by.dzikovskiy.userservice.entity.UserEnum;
import org.testng.annotations.Test;

import java.util.EnumSet;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UserRolesValidatorTest {

    @Test
    public void testValidateIsCorrectNumberOfRoles() {
        EnumSet<UserEnum> roles = EnumSet.noneOf(UserEnum.class);

        roles.add(UserEnum.USER);
        roles.add(UserEnum.PROVIDER);

        assertTrue(UserRolesValidator.validateIsCorrectNumberOfRoles(roles));
    }

    @Test
    public void testValidateIsCorrectNumberOfRolesWithWrongRolesCombination() {
        EnumSet<UserEnum> roles = EnumSet.noneOf(UserEnum.class);
        EnumSet<UserEnum> roles2 = EnumSet.noneOf(UserEnum.class);

        roles.add(UserEnum.USER);
        roles.add(UserEnum.SUPER_ADMIN);

        roles2.add(UserEnum.USER);
        roles2.add(UserEnum.CUSTOMER);

        assertFalse(UserRolesValidator.validateIsCorrectNumberOfRoles(roles));
        assertFalse(UserRolesValidator.validateIsCorrectNumberOfRoles(roles2));
    }


}