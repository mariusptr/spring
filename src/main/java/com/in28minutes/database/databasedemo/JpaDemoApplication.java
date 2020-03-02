package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(JpaDemoApplication.class);

    @Autowired
    PersonJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", repository.findByID(10001));

//        logger.info("User id 10001 -> {}", dao.findByID(10001));
//        logger.info("Deleting 10002 -> Number of rows deleted {}", dao.deleteById(10002));

        logger.info("Inserting 10004 -> {}", repository.insert(new Person("Lara", "Bucharest", new Date())));
        logger.info("Update 10003 -> {}", repository.update(new Person(10001,"Modified Name Update", "Paris", new Date())));
        logger.info("Print all users using JPQL named query {}", repository.findAll());
        //logger.info("Update 10003 -> {}", repository.update(new Person(10001,"Modified Name Update", "Paris", new Date())));
        repository.delete(10001);


    }

}
