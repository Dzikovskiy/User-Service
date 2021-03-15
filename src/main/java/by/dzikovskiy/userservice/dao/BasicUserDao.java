package by.dzikovskiy.userservice.dao;

import by.dzikovskiy.userservice.entity.BasicUser;
import by.dzikovskiy.userservice.service.BasicUserFileHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

public class BasicUserDao {
    private final BasicUserFileHelper fileHelper;
    private final List<BasicUser> users;

    public BasicUserDao() {
        String fileName = "basicUsers.txt";

        try (InputStream input = BasicUserDao.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            //load a properties file from class path
            prop.load(input);
            fileName = prop.getProperty("basicUserFileName");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        this.fileHelper = new BasicUserFileHelper(fileName);
        this.users = fileHelper.readBasicUsersListFromFile();
    }

    public List<BasicUser> getAll() {
        return fileHelper.readBasicUsersListFromFile();
    }

    public void addBasicUser(BasicUser user) {
        if (users.contains(user)) {
            throw new IllegalArgumentException("That user is already in the storage");
        } else {
            users.add(user);
            fileHelper.writeBasicUsersListToFile(users);
        }
    }

    public void removeBasicUser(BasicUser user) {
        if (users.contains(user)) {
            users.remove(user);
            fileHelper.writeBasicUsersListToFile(users);
        } else {
            throw new NoSuchElementException("That user is not in the storage");
        }
    }
}
