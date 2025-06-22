# RESTful API backed for the Widget App

## Requirements

Java 21 -- Java can be acquired using [SDKMAN!](https://sdkman.io/)

## Running the Application

Start the server using Gradle:

```shell
./gradlew bootRun
```

Execute tests using Gradle:

```shell
./gradlew test
```
## Assumptions / Notes

* I have not made use of any database for persisting the widgets. It just stores the values in a List.
* I have added 3 widgets by default just to show something initially. Feel free to delete.