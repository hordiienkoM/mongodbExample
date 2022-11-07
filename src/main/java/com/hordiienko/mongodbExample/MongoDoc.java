package com.hordiienko.mongodbExample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("mongo_doc")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MongoDoc {
    @Id
    private String id;

    private String name;
    private int quantity;
    private String category;
}
