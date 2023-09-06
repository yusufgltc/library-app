# library-app

This is a basic library management application built using Spring, Docker, and various testing techniques. The application allows users to manage books in a library. It utilizes Spring's dependency injection, Faker for generating test data, Mockito for mocking, and includes various testing components such as Spring Web application tests, MVC tests, and database tests.

## Technologies Used

- **Spring Framework**: Used for building the web application and handling dependency injection.
- **Docker**: Used to containerize the application and create separate containers for two different databases.
- **Faker**: Used for generating fake data for testing purposes.
- **Mockito**: Used for mocking dependencies in unit tests.
- **Spring Web Application Tests**: Used to test the web application components.
- **MVC Tests**: Used for testing the application's MVC architecture.
- **Database Tests**: Used for testing database interactions.

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Docker](https://www.docker.com/get-started)

### Running the Application

1. Clone this repository to your local machine:
- git clone <repository-url>

2. Navigate to the project directory:
- cd library-app

3. Build and run the Docker containers for the two databases:
- docker-compose up -d

4. Run unit tests:
- ./mvnw test

5. Run integration tests:
- ./mvnw integration-test
