package com.hordiienko.mongodbExample;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MongoDocRepository extends MongoRepository<MongoDoc, String> {

    @Query("{name:'?0'}")
    MongoDoc findItemByName(String name);

    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<MongoDoc> findAll(String category);
}
