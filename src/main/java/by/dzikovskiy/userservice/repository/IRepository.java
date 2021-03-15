package by.dzikovskiy.userservice.repository;

import java.util.List;

public interface IRepository<T> {

    void save(T t);

    void delete(T t);

    List<T> getAll();
}