# Crest & Thread - Backend API

A RESTful API built with Spring Boot for the Crest & Thread ecommerce platform.

## Features

- **Products API**: CRUD operations, search, filtering, pagination
- **Categories API**: Category management and hierarchy
- **Newsletter API**: Email subscription management
- **CORS Configuration**: Configured for frontend integration
- **API Documentation**: OpenAPI/Swagger documentation

## Tech Stack

- **Spring Boot 3.2** - Application framework
- **Spring Data JPA** - Data persistence
- **H2 Database** - Development database (PostgreSQL for production)
- **Lombok** - Boilerplate reduction
- **SpringDoc OpenAPI** - API documentation

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+

### Installation

```bash
# Build the application
mvn clean install

# Run the application
mvn spring-boot:run

# Or run with java
java -jar target/crest-thread-api-1.0.0-SNAPSHOT.jar
```

### Environment Variables

For production, set the following environment variables:

```bash
# Database
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/crestthread
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=your-password

# CORS
CORS_ALLOWED_ORIGINS=https://yourdomain.com
```

## API Endpoints

### Products

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | Get all products (paginated) |
| GET | `/api/products/{id}` | Get product by ID |
| GET | `/api/products/featured` | Get featured products |
| GET | `/api/products/category/{categoryId}` | Get products by category |
| GET | `/api/products/search?query=` | Search products |

### Categories

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/categories` | Get all categories |
| GET | `/api/categories/{id}` | Get category by ID |
| GET | `/api/categories/slug/{slug}` | Get category by slug |

### Newsletter

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/newsletter/subscribe` | Subscribe to newsletter |
| POST | `/api/newsletter/unsubscribe` | Unsubscribe from newsletter |

## Project Structure

```
backend/
├── src/main/java/com/crestthread/api/
│   ├── config/            # Configuration classes
│   ├── controller/        # REST controllers
│   ├── dto/               # Data Transfer Objects
│   ├── exception/         # Custom exceptions and handlers
│   ├── model/             # JPA entities
│   ├── repository/        # Spring Data repositories
│   ├── service/           # Business logic services
│   └── CrestThreadApplication.java
├── src/main/resources/
│   └── application.yml    # Application configuration
└── pom.xml
```

## API Documentation

When the application is running, access the API documentation at:

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/api-docs

## Database

### Development (H2)

H2 console is available at: http://localhost:8080/h2-console

- JDBC URL: `jdbc:h2:mem:crestthread`
- Username: `sa`
- Password: (empty)

### Production (PostgreSQL)

Configure PostgreSQL in `application.yml` or via environment variables.

## Response Format

All API responses follow a consistent format:

```json
{
  "success": true,
  "message": "Optional message",
  "data": { /* response data */ },
  "error": {
    "code": "ERROR_CODE",
    "message": "Error description",
    "details": {}
  }
}
```

## Error Handling

| HTTP Code | Description |
|-----------|-------------|
| 200 | Success |
| 201 | Created |
| 400 | Bad Request (validation error) |
| 404 | Not Found |
| 409 | Conflict (duplicate resource) |
| 500 | Internal Server Error |

## Health Check

The application exposes health endpoints via Spring Actuator:

- Health: http://localhost:8080/actuator/health
- Info: http://localhost:8080/actuator/info

## License

Copyright © 2024 Crest & Thread. All rights reserved.
