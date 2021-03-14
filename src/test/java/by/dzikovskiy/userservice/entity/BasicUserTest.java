package by.dzikovskiy.userservice.entity;

import org.testng.annotations.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BasicUserTest {

    @Test
    public void testAddRole() {
        BasicUser user = new BasicUser();

        user.addRole(UserEnum.USER);
        user.addRole(UserEnum.SUPER_ADMIN);
        Set<UserEnum> roles = user.getRoles();

        assertEquals(roles.size(), 2);
        assertTrue(roles.contains(UserEnum.USER));
        assertTrue(roles.contains(UserEnum.SUPER_ADMIN));

    }

    @Test
    public void testDeleteRole() {
        BasicUser user = new BasicUser();

        user.addRole(UserEnum.USER);
        user.addRole(UserEnum.SUPER_ADMIN);
        user.deleteRole(UserEnum.USER);
        user.deleteRole(UserEnum.SUPER_ADMIN);

        Set<UserEnum> roles = user.getRoles();

        assertEquals(roles.size(), 0);

    }

    @Test
    public void testAddPhoneNumber() {
        BasicUser user = new BasicUser();
        final String number = "375 291256705";

        user.addPhoneNumber(number);

        assertEquals(user.getPhoneNumbers().size(), 1);
        assertTrue(user.getPhoneNumbers().contains(number));

    }

    @Test
    public void testDeletePhoneNumber() {
        BasicUser user = new BasicUser();
        final String number = "375 291256705";

        user.addPhoneNumber(number);
        user.deletePhoneNumber(number);

        assertTrue(user.getPhoneNumbers().isEmpty());
    }
}