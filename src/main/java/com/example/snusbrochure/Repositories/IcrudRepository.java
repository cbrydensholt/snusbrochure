package com.example.snusbrochure.Repositories;

import java.util.List;

public interface IcrudRepository {

    public interface ICrudRepository<T> {
        void create(T t);
        List<T> readAll();
        T read(long id);
        boolean update(T t);
        boolean delete(long id);
    }

}
