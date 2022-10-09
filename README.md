# Getting Started
## Overview

This is a basic Java application providing a RESTful API for the following operations:
* Get a list of apple bags for sale in the market.
* Add a new apple bag to the market.

## Prerequisite
* Java 17
* Apache Maven 3.8.6

## Run the app
`./mvnw spring-boot:run`

## Test the REST API
`mvn test`

## Endpoint
### List of apple bags for sale in the market
Argument specifies how many apple bags should be returned. If not specified, 3 bags should be returned. If the provided argument is larger than the number of bags on the market, then all possible apple bags are returned.

URL: `localhost:8080/market/`

JSON: `{"quantity":null}`
'null' can be replaced with number of bags that should be returned.

### Add a new apple bag to the market
Argument specifies the apple bag that should be added to the market. This endpoint requires 3 arguments:
* Amount (1 - 100) - Integer
* Supplier ("Royal Gala", "Pink Lady", "Kanzi Apple" or "Elstar Apples") - Text
* Price (1 - 50)  - Double

URL: `localhost:8080/addAppleBag/`

JSON: `{"amount": 3,
        "supplier": "Pink Lady",
        "price": 15.5}`


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.4/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.4/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.7.4/reference/htmlsingle/#using.devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

