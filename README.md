# Order Service - Clean Architecture Demo

Demo project showcasing Clean Architecture principles with Java 21 and Spring Boot 4.

## Architecture

```
src/main/java/com/sconde/example/
├── domain/          # Business logic & entities
├── usecase/         # Use cases (application layer)
├── interfaces/      # REST controllers & DTOs
└── infrastructure/  # DB, external services
```

**Key Principles:**
- Domain independence from frameworks
- Use cases define application behavior
- Interfaces adapt external requests
- Dependency inversion (dependencies point inward)

## Stack

- Java 21
- Spring Boot 4
- Spring Data JPA
- H2 Database (in-memory)
- Lombok

## Endpoints

### Orders
```
POST   /orders              # Create order
POST   /orders/{id}/items   # Add item to order
GET    /orders/{id}         # Get order
POST   /orders/{id}/pay     # Pay order
```

### Products
```
POST   /products            # Create product
GET    /products/{id}       # Get product
GET    /products            # List all products
```

## Quick Start

### Build  
`mvn clean install`

### Run
`mvn spring-boot:run`

### Access H2 Console
http://localhost:8080/h2-console
* JDBC URL: jdbc:h2:mem:orderdb
*  Username: sa
* Password: (leave empty)


## Configuration

The application uses H2 in-memory database by default. Configuration in `application.properties`:
```properties
spring.datasource.url=jdbc:h2:mem:orderdb
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

## Example Usage

```bash
# Create product
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Laptop","price":999.99}'

# Create order
curl -X POST http://localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{"customerId":"CUST001","items":[{"productId":1,"quantity":2}]}'

# Add item to order
curl -X POST http://localhost:8080/orders/1/items \
  -H "Content-Type: application/json" \
  -d '{"productId":1,"quantity":2}'

# Pay order
curl -X POST http://localhost:8080/orders/1/pay
```

## Project Structure

- **domain/model**: Business entities (Order, Product, OrderItem)
- **usecase**: Business operations (CreateOrderUseCase, PayOrderUseCase)
- **usecase/command**: Input DTOs for use cases
- **interfaces/web**: REST controllers
- **interfaces/web/dto**: API request/response models
- **infrastructure**: JPA repositories, adapters

