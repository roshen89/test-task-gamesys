# Gamesys test task

This application is for reading input data from external http source (Buzzfeed.com)  every x seconds-minutes, process data and save them to DB.
Application has API to view results.

## Dependencies

* Java 11
* SpringBoot 2
* Gradle
* H2 database
* MapStruct
* Lombok
* Swagger
* Docker


# Getting Started
## Running application with docker
* Build application
* Run application container with `docker-compose up -d` or `docker-compose up -d --build`
* Stop running container and remove images with `docker-compose down --rmi local`

##Running application via Intellij IDEA
* Run project like a normal SpringBoot application from console or IDEA

## Swagger:
`http://localhost:6969/api/v1/swagger-ui.html`