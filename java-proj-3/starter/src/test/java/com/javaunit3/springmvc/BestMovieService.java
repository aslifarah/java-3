package com.javaunit3.springmvc;

import org.graalvm.compiler.lir.CompositeValue;

@Component
public class BestMovieService {
    private Movie movie;

    @Autowired
    public BestMovieService(@Qualifier("titanicMovie") Movie movie){
        this.movie = movie;
    }
    public Movie getBestMovie(){
        return movie;
    }
}
