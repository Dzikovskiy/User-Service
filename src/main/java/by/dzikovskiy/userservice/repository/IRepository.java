package by.dzikovskiy.userservice.repository;

import java.util.List;

public interface IRepository<T> {

    public void save(T t);
    public void delete(T t);
    public List<T> getAll();
}