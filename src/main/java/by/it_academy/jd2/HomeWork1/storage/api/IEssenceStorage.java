package by.it_academy.jd2.HomeWork1.storage.api;

import java.util.List;

public interface IEssenceStorage <TYPE>{
    List<TYPE> get();
    TYPE get(int id);

    void save (TYPE item);

}
