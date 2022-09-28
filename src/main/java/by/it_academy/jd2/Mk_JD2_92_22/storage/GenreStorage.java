package by.it_academy.jd2.Mk_JD2_92_22.storage;

import by.it_academy.jd2.Mk_JD2_92_22.core.entity.Genre;
import by.it_academy.jd2.Mk_JD2_92_22.core.entity.GenreBuilder;
import by.it_academy.jd2.Mk_JD2_92_22.storage.api.IGenreStorage;

import java.util.ArrayList;
import java.util.List;

public class GenreStorage implements IGenreStorage {

    private static GenreStorage instance = new GenreStorage();

    private List<Genre> data = new ArrayList<>();

    private GenreStorage(){
        this.data.add(GenreBuilder.create()
                .setId(1)
                .setTitle("Хип-хоп").build());

        this.data.add(GenreBuilder.create()
                .setId(2)
                .setTitle("Джаз").build());

        this.data.add(GenreBuilder.create()
                .setId(3)
                .setTitle("Альтернатива").build());

        this.data.add(GenreBuilder.create()
                .setId(4)
                .setTitle("Рок").build());
        this.data.add(GenreBuilder.create()
                .setId(5)
                .setTitle("Реп").build());

        this.data.add(GenreBuilder.create()
                .setId(6)
                .setTitle("Аудио-книги").build());

        this.data.add(GenreBuilder.create()
                .setId(7)
                .setTitle("Классика").build());

    }

    @Override
    public void save(Genre item) {
        this.data.add(item);

    }
    @Override
    public List<Genre> get() {
        return this.data;
    }

    @Override
    public Genre get(int id) {
        return this.data.stream()
                .filter(g -> g.getId() ==id)
                .findFirst()
                .orElse(null);
    }
public static GenreStorage getInstance(){
        return instance;
}

}
