# CampusPulse

## Campus Operations and Intelligence Platform

CampusPulse is a Java-based campus management system that brings common campus services into one application. It allows users to report issues, manage mess feedback, keep track of library books, and manage campus facilities.

The project also includes basic analytics and a rule-based virtual assistant called **Pulse**.

## Features

- Issue Management
  - Report, view, update, and delete campus issues
- Mess Management
  - Add meal records, ratings, and feedback
- Library Management
  - Issue and return books and manage records
- Facilities Management
  - Track facilities, locations, status, and maintenance
- Analytics
  - View summaries for the different modules
- Pulse Assistant
  - Provides basic help and answers common campus-related questions

## Technologies Used

- Java
- JDK 27
- Maven
- MySQL
- JDBC
- MySQL Connector/J
- Eclipse

## Requirements

- JDK 27
- MySQL Server
- MySQL Workbench
- Eclipse IDE
- Maven

## Database Setup

1. Open MySQL Workbench.
2. Run `database.sql`.
3. This creates the `campuspulse` database and required tables.
4. Set the Windows environment variable `CAMPUSPULSE_DB_PASSWORD` to your local MySQL password.
5. Make sure the MySQL username in `DatabaseConnection.java` matches your local MySQL setup.

## How to Run

1. Open the project in Eclipse.
2. Make sure MySQL Server is running.
3. Make sure the database connection details are correct.
4. Update Maven dependencies if required.
5. Run `Main.java` as a Java Application.

## Testing

The application can be tested by using each menu option and checking:

- Adding and viewing records
- Updating records
- Deleting records
- Invalid IDs
- Empty required fields
- Invalid ratings
- Invalid input values
- Analytics results
- Pulse Assistant responses

## Project Files

```text
src/
database.sql
pom.xml
README.md
statement.md