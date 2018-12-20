# mongo-changestream

Mongo change stream sample

# Description

This project is written in vertx and integrated with mongo.
Project deals with mongo change stream functionality. Whenever a change happens in mongo DB, an event will be triggered from Mongo
which can be used to get the changed data.

# How we achieved

Using mongo Change stream functionality.

# Things to know:

We have two services which is written in vertx.
- Mongo insert which happens periodically.
- Mongo change stream service which does the trick of getting the changed data.
