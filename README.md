
# weekly-status-management-springmvc-ui

Based on a Microservice Architecture, this project has been designed and developed as a solution for "Problem Statement #2: Weekly Status Mgmt Micro App" of "Weekly Status Reporting Project". This a simple Front-End UI application developed with JAVA, Spring MVC, and Thymeleaf to display and handle Weekly-Status related CRUD operations.


## Features

This Front-End application provides Thymeleaf based UI for the following operations:

- Create and manage Project wise Weekly-Statuses at company/organization level.
- Search and find individual Project by id and its related details.
- Search and find individual Weekly-Status by id and project_id.
- Update Project wise Weekly-Status related details.
- Delete Project wise Weekly-Status related details.

## Requirements

- Java 1.8+
- Maven 3.0+
- Docker Engine
- Latest MySQL

## Tech Stack

- Java 1.8+
- Maven 3.0+
- Spring Boot 2.7.0+
- JUnit 5
- Docker Engine
- Latest MySQL 8.0+

## Run Locally

Clone the project

```bash
  git clone https://github.com/VipulJadhav12/weekly-status-management-springmvc-ui.git
```

Go to the project directory

```bash
  cd weekly-status-management-springmvc-ui
```

Open and edit the src/main/resources/application.properties file

```bash
  # Port no. at which this application will listen on
  server.port=8282
  server.error.include-message=always

  # Disabling the JDBC Datasource auto-config
  spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

  project.api.url=http://localhost:9292/api/v1/projects
  weekly-status.api.url=http://localhost:9292/api/v1/weekly_statuses  
```

Run the above source code through mvn command line

```bash
  mvn spring-boot:run
```

Compile and Package the above source code as a JAR

```bash
  mvn clean package
```
or
```bash
  mvn clean package -Dmaven.test.skip=true
```

Run the above packaged source code through java command line. For that, go to the target directory

```bash
  java -jar weekly-status-management-springmvc-thymeleaf-ui-0.0.1-SNAPSHOT.jar
```

Main webpages to start to start with

```bash
  http://localhost:<PORT_NO>/displayAllProjects
```

## Running Tests

To run tests, run the following commands

Go to the project directory

```bash
  cd weekly-status-management-springmvc-ui
```

Open and edit the src/test/resources/application.properties file

```bash
  server.port=8282
  server.error.include-message=always

  # Disabling the JDBC Datasource auto-config
  spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

  project.api.url=http://localhost:9292/api/v1/projects
  weekly-status.api.url=http://localhost:9292/api/v1/weekly_statuses
```

Run the unit test-cases through mvn command line

```bash
  mvn test
```

## Authors

- [@krashnat922](https://github.com/krashnat922)
- [@sachin396](https://github.com/sachin396)
- [@VipulJadhav12](https://github.com/VipulJadhav12)

