package by.dzikovskiy.userservice.repository;

import by.dzikovskiy.userservice.dao.BasicUserDao;
import by.dzikovskiy.userservice.entity.BasicUser;

import java.util.List;

public class BasicUserRepository implements IRepository<BasicUser> {

    private final BasicUserDao userDao;

    public BasicUserRepository() {
        this.userDao = new BasicUserDao();
    }

    @Override
    public void save(BasicUser basicUser) {
        userDao.addBasicUser(basicUser);
    }

    @Override
    public void delete(BasicUser basicUser) {
        userDao.removeBasicUser(basicUser);
    }

    @Override
    public List<BasicUser> getAll() {
        return userDao.getAll();
    }
}
