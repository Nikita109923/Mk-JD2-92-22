package by.it_academy.jd2.Mk_JD2_92_22.core.entity;

import java.util.List;

public class ArtistBuilder {
    private  int id;
    private  String name;
    private   String country;
    private  List<String> songs;
    private ArtistBuilder(){}

    public static ArtistBuilder create(){
        return new ArtistBuilder();
    }

    public ArtistBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ArtistBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ArtistBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public ArtistBuilder setSongs(List<String> songs) {
        this.songs = songs;
        return this;
    }

    public Artist build(){
        return new Artist(id,name,country,songs);
}
}
