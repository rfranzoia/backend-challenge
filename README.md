# Invillia Test Implementation

The project is based on a small web service which uses the following technologies:
   
   + Java 8
   + Spring Boot
   + Spring Data (JPA/Hibernate)
   + H2 Database
   + Docker / Docker Compose
   + Swagger
   + Spring Security

The application starts a webserver on port 8080 (http://<server_ip_address>:8080) and serves SwaggerUI where can inspect and 
try existing endpoints. To view the SwaggerUI use the endpoint `http://<server_ip_address>:8080/v2/api-docs`

To build and run the application follow the instructions bellow

    * build the docker image with the spring boot invillia test  application run: 
        `mvn clean package dockerfile:build`

    * run docker image
        `docker run --name it invillia-test`

    * the image will run on a local machine specific Ip Address. To check wich Ip is being
    used open a second terminal window and run the following command:
        `docker inspect it`

The application is also implemented under a simple memory authentication the uses JWT tokens on the request header

	* All endpoints except "http://<server_ip_address>:8080/v2/api-docs" are required to have the Authorization token on the header.
	
	* The endpoint for authentication is "http://<server_ip_address>:8080/login". 
	Please use the json bellow using a POST method to create a new token:

	{
	   "username": "admin",
	   "password": "p4ssw0rd"
	}
	
	* On header from the response of this POST, copy the Authorization into the header of all other endpoint access.



# Invillia recruitment challenge

[![Build Status](https://travis-ci.org/shelsonjava/invillia.svg?branch=master)](https://travis-ci.org/shelsonjava/invillia)

![Invillia Logo](https://invillia.com/public/assets/img/logo-invillia.svg)
[Invillia](https://https://www.invillia.com/) - A transformação começa aqui.

The ACME company is migrating their monolithic system to a microservice architecture and you’re responsible to build their MVP (minimum viable product)  .
https://en.wikipedia.org/wiki/Minimum_viable_product

Your challenge is:
Build an application with those features described below, if you think the requirements aren’t detailed enough please leave a comment (portuguese or english) and proceed as best as you can.

You can choose as many features you think it’s necessary for the MVP,  IT’S NOT necessary build all the features, we strongly recommend to focus on quality over quantity, you’ll be evaluated by the quality of your solution.

If you think something is really necessary but you don’t have enough time to implement please at least explain how you would implement it.

## Tasks

Your task is to develop one (or more, feel free) RESTful service(s) to:
* Create a **Store**
* Update a **Store** information
* Retrieve a **Store** by parameters
* Create an **Order** with items
* Create a **Payment** for an **Order**
* Retrieve an **Order** by parameters
* Refund **Order** or any **Order Item**

Fork this repository and submit your code with partial commits.

## Business Rules

* A **Store** is composed by name and address
* An **Order** is composed by address, confirmation date and status
* An **Order Item** is composed by description, unit price and quantity.
* A **Payment** is composed by status, credit card number and payment date
* An **Order** just should be refunded until ten days after confirmation and the payment is concluded.

## Non functional requirements

Your service(s) must be resilient, fault tolerant, responsive. You should prepare it/them to be highly scalable as possible.

The process should be closest possible to "real-time", balancing your choices in order to achieve the expected
scalability.

## Nice to have features (describe or implement):
* Asynchronous processing
* Database
* Docker
* AWS
* Security
* Swagger
* Clean Code
