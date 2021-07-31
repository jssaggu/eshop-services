# E-Shop using Microservices

## Services

### Products
This project contains product related services.
### Customers
This project contains customer related services.
### Orders
This project contains order related services.<br>
This project depends on both Customer and Product services.<br>

The OrderDao.java contains the services URIs to connect to above services. 
### Local Testing
Update URIs to use localhost
```java
 private static final String CUSTOMER_URI = "http://localhost:8081/customers/%s";
 private static final String PRODUCT_URI = "http://localhost:8082/products/%s";
```
### Container based Testing (Docker / Kubernetes)
Use service name to test in Containers, and use docker-compose to start the services
```java
 private static final String CUSTOMER_URI = "http://customers:8081/customers/%s";
 private static final String PRODUCT_URI = "http://products:8082/products/%s";
  
```

### Docker
* Use `build-images.ksh` script to build all the projects. This script will also create images.
* Use `docker-compose up -d` or `docker compose up -d` to start docker containers.

Once images are deployed and started use the following to test:
* http://localhost:8080/products/P100
  * Other available products: P200, P300
* http://localhost:8080/customers/C100
  * Other available customer: P200, P300
* http://localhost:8080/orders/O100
    * Other available orders: O200, O300
