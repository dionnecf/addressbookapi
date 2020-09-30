# addressbookapi

Built a REST API address book of customers.
The API has the ability to retrieve a
list of customers, and also search for a customer by their surname.

Accepts GET requests only at this stage.

This project uses the following:

* Java 11 (LTS) - 11.0.8

* Spring Boot Starter Parent 2.1.6

* Spring Boot Starter Web 2.3.0

* Spring Boot Starter Test 2.3.0

* Spring Boot Starter Data JPA 2.1.6

* H2 Database 1.4.199

* Junit Jupiter Engine 5.6.2

* Spring Boot Starter Maven Plugin

* Intelli-J IDE 2018.3

* Lombok 1.18.12

* Mockito 2.23.0

# Endpoints

The project will expose the following endpoints:

* /addressbookapi/customers that allows:

# Retrieval of list of customers
A GET request to the endpoint will return existing customers in the system.

* /addressbookapi/customers/{surname} that allows:

# Retrieval of a customer by surname
A GET request to the endpoint will return an existing customer matching the surname in the system.

# Example 1:

curl "localhost:8080/addressbookapi/customers"
the system will respond with:

a 200 OK HTTP response
a list of customers in the system as a JSON object.
If there are no customers in the system, the endpoint will respond with an empty JSON object.

Using Postman or a Browser:

http://localhost:8080/addressbookapi/customers
Data should return like this:

[
    {
        "id": "elaine@dcfhosting.co.uk",
        "firstName": "Elaine",
        "surname": "Condor",
        "address": "123 Anywhere Street",
        "postCode": "E17 6PP"
    },
    {
        "id": "karenstaywell@dcfhosting.co.uk",
        "firstName": "Karen",
        "surname": "Staywell",
        "address": "345 Anywhere Street",
        "postCode": "E17 3AE"
    },
    {
        "id": "pat@dcfhosting.co.uk",
        "firstName": "Patricia",
        "surname": "Farrell",
        "address": "123 Anywhere Street",
        "postCode": "E17 6PP"
    },
    {
        "id": "karen@dcfhosting.co.uk",
        "firstName": "Karen",
        "surname": "Powell",
        "address": "345 Anywhere Street",
        "postCode": "E17 3AE"
    },
    {
        "id": "sidney@dcfhosting.co.uk",
        "firstName": "Sidney",
        "surname": "Poiter",
        "address": "678 Anywhere Street",
        "postCode": "E17 6AA"
    }
]

# Example 2:
curl "localhost:8080/addressbookapi/customers/Farrell"
the system will respond with:

a 200 OK HTTP response
a list of customers in the system that match that surname as a JSON object.
If there are no customers in the system, the endpoint will respond with an empty JSON object.

Using Postman or a Browser:

http://localhost:8080/addressbookapi/customers/Farrell

Data should return like this:

{
    "id": "pat@dcfhosting.co.uk",
    "firstName": "Patricia",
    "surname": "Farrell",
    "address": "123 Anywhere Street",
    "postCode": "E17 6PP"
}

# Non-happy cases

Search for a customer with a surname that doesn't exist will result in a 404 Not Found response

Example 3: curl "localhost:8080/addressbookapi/customers/Smith" - This customer does not exist in the database

a 404 NOT_FOUND HTTP response

JSON repsonse with error:

{
    "timestamp": "2020-09-30T06:06:11.315+0000",
    "status": 404,
    "error": "Not Found",
    "message": "No message available",
    "path": "/addressbookapi/customers/Smith"
}


# Lombok

As this project is using lombok, it is recommended to install a lombok plugin for your favourite IDE.

For example, if you're using IntelliJ IDEA, make sure to install this lombok plugin by going to the Preferences | Plugins | Marketplace - search for `Lombok`, and install and follow the instructions.


# Running the application locally
To run the application locally, use the following command in the project folder(where the pom.xml file is located):

on Unix-like systems:
./mvnw spring-boot:run

on Mac Pro:
mvn spring-boot:run

on Windows:
./mvnw.cmd spring-boot:run





