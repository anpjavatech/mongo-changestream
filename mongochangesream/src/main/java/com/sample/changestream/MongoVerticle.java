package com.sample.changestream;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import io.vertx.core.AbstractVerticle;
import org.bson.Document;


public class MongoVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("products");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    MongoCursor<ChangeStreamDocument<Document>> cursor = collection.watch().iterator();
                    while (cursor.hasNext()) {
                        System.out.println("New entry in mongo :: " + cursor.next().getFullDocument());
                    }
                } catch (Exception e) {
                    System.out.println("Excpetion :: "+e.getMessage());
                }
            }
        }).start();
    }
}
