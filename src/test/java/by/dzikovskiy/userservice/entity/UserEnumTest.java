package by.dzikovskiy.userservice.entity;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UserEnumTest {

    @Test
    public void TestUserEnumReturnUserLevel() {
        assertEquals(UserEnum.USER.getLevel(), 1);
        assertEquals(UserEnum.CUSTOMER.getLevel(), 1);
        assertEquals(UserEnum.ADMIN.getLevel(), 2);
        assertEquals(UserEnum.PROVIDER.getLevel(), 2);
        assertEquals(UserEnum.SUPER_ADMIN.getLevel(), 3);
    }
}
