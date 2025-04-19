# Spring-boot-fom
First of many (FOM) Spring-boot project with h2 database, Thymeleaf templating engine, RESTapi for standalone client is ready, Swagger-UI implemented on RESTapi endpoints.
This project was made as an assignment for a job application.

Starting app

In terminal of your choice navigate to root folder of this project (the same folder where this README.md file is located).

1. U have installed Maven:

mvn clean install

mvn spring-boot:run

2. Don't have Maven: // use a maven wrapper which is bundled in the project of this repo

mvnw clean install

mvnw spring-boot:run


Thymeleaf UI:

http://localhost:8080/thyme/create - creating a new product

http://localhost:8080/thyme/filter - filtering products by name or/and code 

http://localhost:8080/thyme/popular-products - getting info about 3 best rated products


Assignment specifications:

Task – Spring REST API
The task is to create a simple REST service with operations for managing products and their reviews.
Submit a link to the repository (GitHub, Bitbucket...) containing the solution.

Technologies
Java 8+

Maven

Git

Spring Boot

H2 Database

Model
1. PRODUCT
ID (autogenerated)

CODE (unique, exactly 15 characters)

NAME

PRICE_EUR

PRICE_USD

DESCRIPTION

2. REVIEW
ID (autogenerated)

PRODUCT_ID (foreign key referencing PRODUCT)

REVIEWER

TEXT

RATING (number from 1 to 5)

When the application starts, it should insert predefined data – at least 5 products and at least 2 reviews per product.

Endpoints
1. Add Product
Enable input of product CODE, NAME, PRICE_EUR and DESCRIPTION.
The PRICE_USD should be calculated by calling the HNB API v3: http://api.hnb.hr/

2. Get Products
Enable fetching a list of products using optional filters: code and name.
Both filters should be case-insensitive and allow partial matches (i.e., return products whose code or name contains the provided value).

3. Get Popular Products
An endpoint that returns the top three most popular products.
The popularity is calculated based on the average rating from the review table.
Return the three products with the highest average rating.
The response object should look like this (rating rounded to one decimal place):

{
"popularProducts" : [
{
"name" : "Samsung Galaxy S23" ,
"averageRating" : 4.8
},
{
"name" : "iPhone SE" ,
"averageRating" : 4.8
},
{
"name" : "Xiaomi 13" ,
"averageRating" : 4.5
}
]
}


EXTRA:

Music listened while coding:
https://www.youtube.com/watch?v=aCXzh20qehU&ab_channel=SamuraiWorkTunes   (Midnight Groove: Japanese-Inspired 90s Hip Hop for Intense Concentration & Relaxed Evenings)

https://www.youtube.com/watch?v=zZ_-c67JFtI&ab_channel=SamuraiWorkTunes   (Shamisen and 90s Hip Hop | Rhythms to Power Your Workflow)