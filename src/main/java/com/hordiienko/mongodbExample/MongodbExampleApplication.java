package com.hordiienko.mongodbExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class MongodbExampleApplication {
    @Autowired
    private MongoDocService mongoDocService;
    public static void main(String[] args) {
        SpringApplication.run(MongodbExampleApplication.class, args);
    }


}
