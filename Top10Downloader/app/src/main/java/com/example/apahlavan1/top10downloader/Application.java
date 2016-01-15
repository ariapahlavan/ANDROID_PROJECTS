package com.example.apahlavan1.top10downloader;

/**
 * Created by apahlavan1 on 1/1/2016.
 */
public class Application {
    private String name;
    private String artist;
    private String releaseDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return  "Name: " + getName() + "\n" +
                "Artist: " + getArtist() + "\n" +
                "Release Date: " + getReleaseDate();
    }
}
