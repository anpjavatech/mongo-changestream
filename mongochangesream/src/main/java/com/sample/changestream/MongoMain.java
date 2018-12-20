package com.sample.changestream;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

public class MongoMain {
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(MongoVerticle.class.getName(), new DeploymentOptions().setWorker(true).setMaxWorkerExecuteTime(Long.MAX_VALUE));
    }
}
