# Smart City - Citizen Engagement - Spring Boot Skeleton

*Team :* Richard Amman, Quentin de Lattre

*Heroku URL :* [`https://evening-badlands-7537.herokuapp.com`](https://evening-badlands-7537.herokuapp.com)

## Introduction

The implementation is done with:

- [Spring Boot](http://projects.spring.io/spring-boot/)
- [Spring Data MongoDB](http://projects.spring.io/spring-data-mongodb/)
- [MongoDB](http://www.mongodb.org/)
- [Jersey](https://jersey.java.net/)

## Requirements

- Java 1.7+
- Maven 3.0.5+
- Mongo 2.6+

## Implementation

Base your implementation on the info from [iFlux blog's post](http://www.iflux.io/use-case/2015/02/03/citizen-engagement.html).

## Configure

Rename the root package to a name of your choice and change the groupId in `pom.xml` to an appropriate one.

If you want, you can change the DB name in the property file present in `src/main/resources`. The other configuration values work fine for development.

## Install / Deploy / Run

Just run the following command (or use the proper Run goal in Custom in NetBeans). Be sure MongoDB is running before running the command.

```bash
$> mvn clean package spring-boot:run
```

## Test

The appliation is runing on `http://localhost:8080`. You should be able to access the following:

### Data population

- POST /api/data/populate

### User resource

- GET /api/users
- POST /api/users
- GET /api/users/{id}
- PUT /api/users/{id}
- DELETE /api/users/{id}

## Deploy on Heroku

1. Create the application in the Heroku admin console
2. If not already done, provide Credit Card infos
3. Type the command in the directory app on your machine `heroku addons:add mongolab`
4. Visit again your Heroku admin console to view the app details. You will find a link to see the admin console of the addon.
5. Once you are in the admin console of the addon, you can create a new database user. Do it with the following info:
	- User: `cityengagement`
	- Password: `cityengagement`
6. Configure environment variable to start the app with the following commands:
	- Set the user: `heroku config:set SB_MONGO_USER=cityengagement`
	- Set the password: `heroku config:set SB_MONGO_PASSWORD=cityengagement`
	- Set the db name: `heroku config:set SB_MONGO_DB={dbName}`
	- Set the host: `heroku config:set SB_MONGO_HOST={host}`
	- Set the port: `heroku config:set SB_MONGO_PORT={port}`
	- Set the environment: `heroku config:set SB_ENV=production`
7. Finally, you can push your code to Heroku
	- cmd: `git push heroku master`
