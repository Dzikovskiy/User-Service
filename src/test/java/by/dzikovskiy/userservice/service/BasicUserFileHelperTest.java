package by.dzikovskiy.userservice.service;

import by.dzikovskiy.userservice.entity.BasicUser;
import by.dzikovskiy.userservice.entity.UserEnum;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BasicUserFileHelperTest {

    @Test
    public void testWriteAndReadBasicUsersListToAndFromFile() {
        List<BasicUser> basicUsers = new ArrayList<>();
        BasicUserFileHelper fileHelper = new BasicUserFileHelper("testUsers.txt");
        BasicUser user1 = new BasicUser();
        user1.setName("name1");
        user1.setSurname("surname1");
        user1.setEmail("user1@mail.com");
        user1.addPhoneNumber("375 292456707");
        user1.addRole(UserEnum.USER);
        BasicUser user2 = new BasicUser();
        user2.setName("name2");
        user2.setSurname("surname2");
        user2.setEmail("user2@mail.com");
        user2.addPhoneNumber("375 252454817");
        user2.addRole(UserEnum.USER);
        user2.addRole(UserEnum.SUPER_ADMIN);

        basicUsers.add(user1);
        basicUsers.add(user2);

        fileHelper.writeBasicUsersListToFile(basicUsers);
        List<BasicUser> basicUsersFromFile = fileHelper.readBasicUsersListFromFile();

        assertEquals(basicUsers.size(), basicUsersFromFile.size());
        assertEquals(basicUsers, basicUsersFromFile);

    }
}