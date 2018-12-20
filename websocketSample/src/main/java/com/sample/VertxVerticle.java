package com.sample;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;

public class VertxVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        JsonObject mongoconfig = new JsonObject()
                .put("connection_string", "mongodb://localhost:27017")
                .put("db_name", "test");
        MongoClient mongoClient = MongoClient.createShared(vertx, mongoconfig);

        Long timerId = vertx.setPeriodic(3000, han -> {
            int counter = (int)(Math.random()*1000);
            JsonObject product1 = new JsonObject().put("itemId",counter).put("name", "Cooler-"+counter).put("price", "100.0"+counter);
            System.out.println("Timer triggered..");
            mongoClient.save("products", product1, id -> {

            });
        });
    }
}
