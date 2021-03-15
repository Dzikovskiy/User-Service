package by.dzikovskiy.userservice.dao;

import by.dzikovskiy.userservice.entity.BasicUser;
import by.dzikovskiy.userservice.entity.UserEnum;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class BasicUserDaoTest {

    @BeforeTest
    @AfterTest
    @AfterMethod
    public static void clean() {
        String fileName = "testUsers.txt";
        try (InputStream input = BasicUserDao.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            //load a properties file from class path
            prop.load(input);
            fileName = prop.getProperty("basicUserFileName");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        File file = new File(fileName);

        file.delete();
    }


    @Test
    public void testGetAllAfterAddUsers() {
        List<BasicUser> basicUsers = new ArrayList<>();
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

        BasicUserDao basicUserDao = new BasicUserDao();
        basicUserDao.addBasicUser(user1);
        basicUserDao.addBasicUser(user2);

        assertEquals(basicUsers, basicUserDao.getAll());
    }


    @Test
    public void testRemoveBasicUser() {
        List<BasicUser> basicUsers = new ArrayList<>();
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

        BasicUserDao basicUserDao = new BasicUserDao();
        basicUserDao.addBasicUser(user1);
        basicUserDao.addBasicUser(user2);
        basicUserDao.removeBasicUser(user2);

        assertEquals(basicUsers, basicUserDao.getAll());
        assertEquals(basicUsers.size(), basicUserDao.getAll().size());
    }
}