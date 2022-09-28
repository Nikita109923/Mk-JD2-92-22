package by.it_academy.jd2.Mk_JD2_92_22.core.entity;

import java.util.List;

public class Artist   {
    private final int id;
    private final String name;
    private  final String country;
    private final List<String> songs;

    public Artist(int id, String name, String country, List<String> songs) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.songs = songs;
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }



    public String getCountry() {
        return country;
    }



    public List<String> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", songs=" + songs +
                '}';
    }
}
