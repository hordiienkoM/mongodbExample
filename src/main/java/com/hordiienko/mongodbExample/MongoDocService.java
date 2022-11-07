package com.hordiienko.mongodbExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoDocService {
    @Autowired
    private MongoDocRepository mongoDocRepository;
    public void createMongoDocs() {
        System.out.println("Data creation started...");
        mongoDocRepository.save(new MongoDoc("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
        mongoDocRepository.save(new MongoDoc("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
        mongoDocRepository.save(new MongoDoc("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
        mongoDocRepository.save(new MongoDoc("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
        mongoDocRepository.save(new MongoDoc("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
        System.out.println("Data creation complete...");
    }

    // 1. Show all the data
    public void showAllMongoDocs() {

        mongoDocRepository.findAll().forEach(doc -> System.out.println(getMongoDocDetails(doc)));
    }

    // 2. Get item by name
    public void getMongoDocByName(String name) {
        System.out.println("Getting item by name: " + name);
        MongoDoc item = mongoDocRepository.findItemByName(name);
        System.out.println(getMongoDocDetails(item));
    }

    // 3. Get name and quantity of a all items of a particular category
    public void getItemsByCategory(String category) {
        System.out.println("Getting items for the category " + category);
        List<MongoDoc> list = mongoDocRepository.findAll(category);

        list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
    }

    // 4. Get count of documents in the collection
    public void findCountOfMongoDocs() {
        long count = mongoDocRepository.count();
        System.out.println("Number of documents in the collection: " + count);
    }

    public String getMongoDocDetails(MongoDoc doc) {

        System.out.println(
                "Document Name: " + doc.getName() +
                        ", \nQuantity: " + doc.getQuantity() +
                        ", \nItem Category: " + doc.getCategory()
        );

        return "";
    }

    public void run() {

        System.out.println("-------------CREATE GROCERY ITEMS-------------------------------\n");

        createMongoDocs();

        System.out.println("\n----------------SHOW ALL GROCERY ITEMS---------------------------\n");

        showAllMongoDocs();

        System.out.println("\n--------------GET ITEM BY NAME-----------------------------------\n");

        getMongoDocByName("Whole Wheat Biscuit");

        System.out.println("\n-----------GET ITEMS BY CATEGORY---------------------------------\n");

        getItemsByCategory("millets");

        System.out.println("\n-----------UPDATE CATEGORY NAME OF SNACKS CATEGORY----------------\n");

        System.out.println("\n------------FINAL COUNT OF GROCERY ITEMS-------------------------\n");

        findCountOfMongoDocs();

        System.out.println("\n-------------------THANK YOU---------------------------");

    }
}
