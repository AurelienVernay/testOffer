# TestOffer

## Prerequisites

- Docker + docker-compose installed on system.
- Java JDK 11 installed
- local machine must have ports `5432` and `8880` free (used respectively for db and backend)

## Quickstart

1. launch docker db container : `cd docker && docker-compose up -d`
2. launch API via gradle wrapper : `cd backend && ./gradlew bootRun`

## Conception

### _Person_ Table

_Person_ entity is defined as such :
| name| type| nullable | constraint
--- | --- | --- | --- |
| id | int | false | |
| firstname | varchar | true |
| lastname | varchar | false |
| date_birth | Date | false |
| gender | char | false | `gender == 'C' \|\| gender == 'M'` |

## Detailed architecture

### Docker

Docker container inside `docker` directory running PostgreSQL 13.3 database.
User `postgres` set with `example` password.
This example API uses database `postgres` --> _schema `public`_.

### Java Backend

**Spring Boot 2.5.1** (Spring web + JPA + AOP) built using Gradle.
_(Used as much default handlers / resolvers / configuration as i could, of course it should be more detailed / configured / fine-tuned in a project in production)_

**Lombok** is used to generate getters / setters on models classes.

DB initialization / versioning is done by Liquibase changelog master (check out `src/main/resources/db/changelog/db.changelog-master.yaml`)

The App is structured with :

- Models : (`Person` class, bound to database table with `@Entity` Annotation)
- Repositories : (`PersonRepository` interface implements `JpaRepository` in order to access standard JPA methods)
- Services : (`PersonService` interface defines methods, `PersonServiceImpl` class implements them)
- Endpoints : (`PersonEndpoint`exposes 2 methods using `@RestController` annotations)

AOP Logging is defined through `spring-context.xml` (in order to allow dynamic reconfiguration instead of using @Aspect annotations) by defining `<AOP:config>` tag. It defines `servicePointcut` that uses `MyLogger` class to log any method call inside `com.aureltest.testOffer.services` package (before logs method name & arguments, afterReturning log method call return value)

Custom business logic error handling is done by `PersonErrorHandler` and `PersonLogicException` classes.

Other system errors should be rendered by the Spring Boot standard `ResponseStatusException`.

## Testing

Sample unit tests can be found under `test/java/com/aureltest/testOffer/TestOfferApplicationTests.java`.

Simply run the `./gradlew test` command to generate test results inside `build/test-results/test` directory.
