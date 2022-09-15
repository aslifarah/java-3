package com.javaunit3.springmvc;
import com.javaunit3.springmvc.Movie;

public class BatmanMovie implements Movie {

    public String getTitle() {
        return "Batman: The Dark Knight";
    }

    public String getMaturityRating() {
        return "PG-13";
    }

    public String getGenre() {
        return "Action";
    }
}