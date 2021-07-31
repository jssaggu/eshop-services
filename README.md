# E-Shop using Microservices

## Services

### Products
This project contains product related services.

### Customers
This project contains customer related services.

### Orders
This project contains order related services.<br>
This project depends on both Customer and Product services.<br>

### API Gateway
Spring Gateway (Formerly known as Zuul)

The OrderDao.java contains the services URIs to connect to above services.

Application uses `default` and `prod` profiles.

### Local Testing
When applications started using IDE or from command-prompt then it will automatically use `default profile.` 

### Container based Testing (Docker / Kubernetes)
When running services inside docker containers then it uses `prod` profile and 
services URIs will be picked up from the application.yml files of the relevant application.  

### Docker
* Use `build-images.ksh` script to build all the projects. This script will also create images.
* Use `docker-compose up -d` or `docker compose up -d` to start docker containers.

All in one: `./build-images.ksh; docker compose up -d`

Once Docker containers started then use the following to test:
* http://localhost:8080/products/P100
  * Other available products: P200, P300
* http://localhost:8080/customers/C100
  * Other available customer: P200, P300
* http://localhost:8080/orders/O100
    * Other available orders: O200, O300
