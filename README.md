# myRetail RESTful service
The project consists of two mock core microservices, the product-info and product-price services, all of which deal with one type of resource, and a composite microservice product-composite service, which aggregates information from the two mock services. 
## product-info
This service manages product information and describes each product with the following attributes:

* Product ID
* Name

The data is mocked in a json file.
## product-price
This service manages product price and contains following attributes:

* Product ID
* Current Price
    * Currency Code
    * Value
    
The data is persisted in NoSQL MongoDB to support the company's rapidly growing data.

## product-composite
product-composite aggregates information from the two core services and presents information about a product as follows:
* Product ID
* Name
* Current Price
    * Currency Code
    * Value
    
 Custom ProductException for a uniform exception handling across the service that returns
* timestamp
* error message

Enabled API documentation via Swagger.

    
## Set up
* Execute this in the main directory of the project to build all projects and create docker images in one go via 
``` 
mvn clean install
```
* Containers can be started on a docker network by simply running the docker-compose command:
```
docker-compose up -d
```

## Testing
product-composite exposes a GET endpoint `/products/{productId}`

Successful test requests

* http://localhost:8080/products/13860428
* http://localhost:8080/products/13860430
