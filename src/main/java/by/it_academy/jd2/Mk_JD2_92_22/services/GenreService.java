package by.it_academy.jd2.Mk_JD2_92_22.services;

import by.it_academy.jd2.Mk_JD2_92_22.core.entity.Genre;
import by.it_academy.jd2.Mk_JD2_92_22.services.api.IGenreService;
import by.it_academy.jd2.Mk_JD2_92_22.storage.ArtistStorage;
import by.it_academy.jd2.Mk_JD2_92_22.storage.GenreStorage;
import by.it_academy.jd2.Mk_JD2_92_22.storage.api.IArtistStorage;
import by.it_academy.jd2.Mk_JD2_92_22.storage.api.IGenreStorage;

import java.util.List;

public class GenreService implements IGenreService {
    private static final GenreService instance = new GenreService();
    private final IGenreStorage storage;
    private GenreService(){
        this.storage = GenreStorage.getInstance();
    }

    @Override
    public List<Genre> get() {
        return  this.storage.get();
    }

    @Override
    public Genre get(int id) {
        return this.storage.get(id);
    }

    @Override
    public void validate(Genre item) {
        if(item==null){
            throw new IllegalStateException("Вы не передали жанр");
        }

        if(item.getTitle()==null || item.getTitle().isBlank()){
            throw new IllegalArgumentException("Вы не передали название жанра");
        }
    }
        public static GenreService getInstance() {
            return instance; }
}

