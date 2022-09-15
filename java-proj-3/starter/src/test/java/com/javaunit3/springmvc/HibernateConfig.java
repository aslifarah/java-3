package com.javaunit3.springmvc;

@Configuration
public class HibernateConfig {
    SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    return factory;
}