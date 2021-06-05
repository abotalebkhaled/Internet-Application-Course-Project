package DAO;

import java.util.List;


public interface IDAO<T>
{
    T get(int _id);
    List<T> getAll();
    int save(T _t);
    boolean delete(int _id);
}
