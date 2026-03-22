package com.example.week10;

public class Movie {
    private String title;
    private String year;
    private String genre;
    private String posterResource;

    public Movie(String title, String year, String genre, String posterResource) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.posterResource = posterResource;
    }

    public String getTitle() {
        return title;
    }
    public String getYear() {
        return year;
    }
    public String getGenre() {
        return genre;
    }
    public String getPosterResource() {
        return posterResource;
    }


}
