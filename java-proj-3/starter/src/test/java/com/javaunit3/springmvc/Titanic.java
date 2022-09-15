package com.javaunit3.springmvc;

import com.javaunit3.springmvc.Movie;

@Component
public class TitanicMovie implements Movie {
    public String getTitle(){
        return "Titanic";
    }
    public String getMaturityRating(){
        return "PG-13";
    }
    public String getGenre(){
        return "Romance";
    }
}