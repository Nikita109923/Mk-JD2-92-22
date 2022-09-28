package by.it_academy.jd2.Mk_JD2_92_22.services;

import by.it_academy.jd2.Mk_JD2_92_22.core.entity.Artist;
import by.it_academy.jd2.Mk_JD2_92_22.services.api.IArtistService;
import by.it_academy.jd2.Mk_JD2_92_22.storage.ArtistStorage;
import by.it_academy.jd2.Mk_JD2_92_22.storage.api.IArtistStorage;

import java.util.List;

public class ArtistService  implements IArtistService {
    private static final ArtistService instance = new ArtistService();
    private final IArtistStorage storage;
    private ArtistService(){
        this.storage = ArtistStorage.getInstance();
    }

    @Override
    public List<Artist> get() {
        return this.storage.get();
    }

    @Override
    public Artist get(int id) {
        return this.storage.get(id);
    }

    @Override
    public void validate(Artist item) {
        if(item==null){
            throw new IllegalStateException("Вы не передали артиста");
        }

        if(item.getName()==null || item.getName().isBlank()){
            throw new IllegalArgumentException("Вы не передали имя артиста");
        }


    }
    public static ArtistService getInstance() {
        return instance;
}
}
