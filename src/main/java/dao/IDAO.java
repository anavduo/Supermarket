package dao;

import java.util.List;

public interface IDAO<T,K>{
    //Using generics
    void create (T t);
    T get(K id);
    void update(T t);
    void delete(T t);
    List<T> getAll();

}
