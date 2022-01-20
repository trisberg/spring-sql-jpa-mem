# Spring Boot JPA application accessing an SQL database

## Introduction

This is a Spring Boot application that accesses an SQL database.  The data model is a `User` that has an id, name and email address.  There is one controller with two endpoints:

* `/demo/all` - lists all users  (GET REQUEST)
* `/demo/add` - add a user (POST REQUEST)

> This sample is based on the Spring [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/) guide, although we changed it to use a PostgreSQL database.

## Building and running locally

### Using HSQLDB

We can build and run this app locally using an embedded HSQL database.

To build the app as an uberjar run:

```
./mvnw clean package 
```

To start the application locally with an embedded database run:

```
./mvnw spring-boot:run
```

See [Accessing the app](#accessing-the-app) for commands to test the app.

### Using PostgreSQL with Docker

We can build and run this app locally using a PostgreSQL database running in a Docker container.

To start the PostgreSQL container run:

```
docker run --rm -it --name postgres -p 5432:5432 \
  -e POSTGRES_USER=tanzu -e POSTGRES_PASSWORD=s3cret -e POSTGRES_DB=test \
  -d postgres
```

To build the app as an uberjar run:

```
./mvnw clean package
```

To start the application locally with an embedded database run:

```
./mvnw spring-boot:run -Dspring-boot.run.profiles=postgresql
```

You can also use the built uberjar using:

```
java -jar target/spring-sql-jpa-0.0.1-SNAPSHOT.jar \
  --spring.profiles.active=postgresql
```

See [Accessing the app](#accessing-the-app) for commands to test the app.

### Accessing the app

To view the users run:

```
curl -w'\n' localhost:8080/demo/all
```

To add a user run:

```
curl -w'\n' localhost:8080/demo/add \
 -d name=First \
 -d email=someemail@someemailprovider.com
```
