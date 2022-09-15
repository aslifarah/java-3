package com.javaunit3.springmvc;

import java.util.Comparator;
import java.util.List;

@Controller
public class MovieController {
    @RequestMapping("/")
    public String getIndexPage(){
        return "index";
    }
    @RequestMapping("/bestMovie")
    public String getBestMoviePage(Model model)  {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        // You can also try simply querying for the movie with the most votes. For simplicity, we query for all of the records here List<MovieEntity> movieEntityList = session.createQuery(“from MovieEntity”).list();
        movieEntityList.sort(Comparator.comparingInt(movieEntity -> movieEntity.getVotes().size()));
        MovieEntity movieWithMostVotes = movieEntityList.get(movieEntityList.size() - 1);
        List<String> voterNames = new ArrayList<>();
        for(VoteEntity vote : movieWithMostVotes.getVotes()) {
            voterNames.add(vote.getVoterName());
        }
        String voterNamesList = String.join(",", voterNames);
        model.addAttribute("bestMovie", movieWithMostVotes.getTitle()); model.addAttribute("bestMovieVoters", voterNamesList);
        session.getTransaction().commit(); return "bestMovie";
    }
    @RequestMapping("/voteForBestMovieForm")
    public String voteForBestMovieFormPage() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list(); session.getTransaction().commit();
        model.addAttribute("movies", movieEntityList); return "voteForBestMovie";
    }
    @RequestMapping("/voteForBestMovie")
    public String voteForBestMovie(HttpServletRequest request, Model model) {
        String movieId = request.getParameter("movieId");
        String voterName = request.getParameter("voterName");

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        MovieEntity movieEntity = (MovieEntity) session.get(MovieEntity.class, Integer.parseInt(movieId));
        VoteEntity newVote = new VoteEntity();
        newVote.setVoterName(voterName);
        movieEntity.addVote(newVote);

        session.update(movieEntity);

        session.getTransaction().commit();

        return "voteForBestMovie";
    }
    @Autowired
    private SessionFactory sessionFactory;

    //In MovieController, create a method addMovieForm with the request mapping “/addMovieForm”. Simply return “addMovie” to direct to the addMovie.html view.
    @RequestMapping("/addMovieForm")
    public String addMovieForm() {
        return "addMovie";
    }
}
