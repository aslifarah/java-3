package com.javaunit3.springmvc;

import java.util.List;

@Entity
@Table(name = "movies")
public class MovieEntity {

    // Create a private Integer field id, and annotate it so that it is the primary key, as well as a generated value. Name the column corresponding to this field as “movie_id”.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer id;

    // Create private fields for the title, maturity ratings, and genre. Annotate these properties and name the table columns “title”, “maturity_rating”, and “genre”
    @Column(name = "title")
    private String title;

    @Column(name="maturity_rating")
    private String maturityRating;

    @Column(name="genre")
    private String genre;

    // Create getters and setters for all private properties.
    public String getMaturityRating() {
        return maturityRating;
    }

    public void setMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // In the HibernateConfig class, add MovieEntity as an annotated class to the SessionFactory.
    SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(MovieEntity.class).buildSessionFactory();


// Modify MovieEntity to have a private field of type List<VoteEntity>. Using hibernate annotations, indicate a one to many mapping and a join column named “movie_id”. Make sure to create all of the necessary getters and setters. Also create an addVote() method that adds a vote to the list.

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private List<VoteEntity> votes;

    public List<VoteEntity> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteEntity> votes) {
        this.votes = votes;
    }

    public void addVote(VoteEntity vote) {
        this.votes.add(vote);
    }
}
