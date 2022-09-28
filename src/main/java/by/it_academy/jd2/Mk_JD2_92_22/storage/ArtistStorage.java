package by.it_academy.jd2.Mk_JD2_92_22.storage;

import by.it_academy.jd2.Mk_JD2_92_22.core.entity.Artist;
import by.it_academy.jd2.Mk_JD2_92_22.core.entity.ArtistBuilder;
import by.it_academy.jd2.Mk_JD2_92_22.storage.api.IArtistStorage;

import java.util.ArrayList;
import java.util.List;

public class ArtistStorage implements IArtistStorage {

    private static ArtistStorage instance = new ArtistStorage();
    private List<Artist> data = new ArrayList<>();

    private ArtistStorage(){
        this.data.add(ArtistBuilder.create()
                .setId(1)
                .setName("Сектор газа")
                .build());

        this.data.add(ArtistBuilder.create()
                .setId(2)
                .setName("Риана")
                .build());

        this.data.add(ArtistBuilder.create()
                .setId(3)
                .setName("Снупдок")
                .build());

        this.data.add(ArtistBuilder.create()
                .setId(4)
                .setName("Рамштайн")
                .build());
    }

    @Override
    public void save(Artist item) {
        this.data.add(item);
    }

    @Override
    public List<Artist> get() {
        return this.data;
    }

    @Override
    public Artist get(int id) {
        return this.data.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static ArtistStorage getInstance(){
        return instance;
    }
}