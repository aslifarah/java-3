package com.javaunit3.springmvc;

public class VoteEntity {
    // Create a new VoteEntity class with a generated id field and a field for the voter's name. Make sure to create all of the necessary getters and setters.
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name ="voter_name")
    private String voterName;

    // Add the VoteEntity class to your session factory configuration in HibernateConfig.java.
    SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(MovieEntity.class).addAnnotatedClass(VoteEntity.class).buildSessionFactory();


}
