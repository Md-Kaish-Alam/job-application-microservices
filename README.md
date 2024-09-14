# Job Application Backend Project

This repository contains a backend application built for managing job applications using microservices architecture. The application is developed using **Spring Boot**, with multiple services such as **JOB**, **COMPANY**, and **REVIEW**. Each service operates independently with its own database. The project demonstrates a robust architecture with service registry, inter-service communication, fault tolerance, tracing, and containerization.

## Technologies Used
  - Spring Boot
  - Spring Cloud (Eureka, Config Server, API Gateway)
  - PostgreSQL (with Docker)
  - RabbitMQ
  - Zipkin (Distributed Tracing)
  - Resilience4J (Circuit Breaking)
  - Docker
  - Kubernetes

## Architecture Overview

### Microservices

1. **JOB Service**: Handles job-related operations such as job creation and listing.
2. **COMPANY Service**: Manages company profiles and ratings.
3. **REVIEW Service**: Manages user reviews for jobs and companies.

Each microservice is independent and communicates via REST APIs.

### Inter-Service Communication

- **RestTemplate**: Synchronous communication between services.
- **@LoadBalanced**: Enables communication via service names instead of hardcoded URLs.

### API Gateway

- **Spring Cloud Gateway**: Acts as a single entry point for all microservices, providing routing, filtering, and service discovery features.

### Fault Tolerance

- **Resilience4J**: Circuit breaking, retry mechanisms, and rate limiting implemented for fault-tolerant services.

### Distributed Tracing

- **Zipkin**: Integrated with Micrometer for tracing requests across the microservices.

### Configuration Management

- **Spring Cloud Config Server**: Centralized configuration management using a Git repository.


## Features

- **Microservices Architecture**: JOB, COMPANY, and REVIEW services are completely independent and utilize different databases.
  
  ![Application Architecture](https://github.com/user-attachments/assets/6cebc3cc-cef8-4cc9-bfd5-5cee2bb36f85)
  
- **Databases**: 
  - **H2** for testing 
  - **PostgreSQL** via `postgres-0` Docker image for production
- **Synchronous Communication**: Inter-service communication through **RestTemplate** using DTO pattern.

  ![Rest Template](https://github.com/user-attachments/assets/7dfc6b2f-4c03-4f5a-9c13-71fb307fa9fc)

  ![DTO Patterns](https://github.com/user-attachments/assets/a003729a-440e-4d47-8d2b-22ac01f9f7c1)
  
- **Service Registry**: 
  - Setup with **Eureka Server**.
  - Each service is registered with Eureka for service discovery.
  - HeartBeat Mechanism for continuous monitoring.

  ![Service Registry](https://github.com/user-attachments/assets/8200b999-2575-46f9-8a75-2e52015ee076)

  Behind the seen of Eureka Service Registry

  ![eureka service](https://github.com/user-attachments/assets/7f7650f8-8293-4849-a252-489c96b57f95)
    
- **API Gateway**: Implemented using **Spring Cloud Gateway**.
  - Supports service discovery with Eureka.
  - Handles routing between microservices.

  ![Api Gateway](https://github.com/user-attachments/assets/bc325278-4bd1-43bc-be1b-11846a4ffa3e)

- **Fault Tolerance and Circuit Breaking**: 
  - Integrated **Resilience4J** for circuit breaking, retry mechanisms, and rate limiting.
  - Fall-back mechanisms in place to ensure service availability.
- **RabbitMQ Integration**: 
  - Message queue setup for publishing and consuming messages between services.
  - Real-time updates of company ratings using RabbitMQ queues.
    
  ![RabbitMQ](https://github.com/user-attachments/assets/1e938425-9f39-44dc-86c2-0a7ff32390ff)
  
- **Distributed Tracing**: 
  - **Zipkin** integration for tracing requests across services using Micrometer.
- **Configuration Management**: 
  - **Spring Cloud Config Server** is used to manage centralized configuration.
  - Mapped to a Git repository for version-controlled configurations.
  
  ![config server](https://github.com/user-attachments/assets/ce9df250-6f24-4a31-ad2a-c2767095c6b2)
  
- **Dockerization**: 
  - All microservices are containerized using Docker.
  - Multi-container setup using **Docker Compose**.
  - **Spring Boot Profiles** for development and production environments.

  ![Screenshot 2024-09-14 072237](https://github.com/user-attachments/assets/6cd3b6ed-8b0d-4097-ad61-8af805e57fe4)

  ![Screenshot 2024-09-14 072308](https://github.com/user-attachments/assets/3e83097c-2369-4464-8661-7e71dc1cf357)
  
- **Kubernetes Deployment**:
  - Deployed on Kubernetes using **Minikube**.
  - Includes setup for **Pods**, **ReplicaSets**, and **Deployments**.

![screencapture-127-0-0-1-59781-api-v1-namespaces-kubernetes-dashboard-services-http-kubernetes-dashboard-proxy-2024-09-12-16_55_56](https://github.com/user-attachments/assets/a6bf1ede-7c93-4b99-9d59-e61b3f7019b1)

## Getting Started

### Prerequisites

- **Java 17**
- **Maven**
- **Docker**
- **Kubernetes (Minikube)**

### Running the Project

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/job-application-backend.git
   cd job-application-backend
   ```
   
2. Build the project using Maven:

   ```bash
   mvn clean install 
   ```
   
3. Start the application using Docker:

   ```bash
   mvn clean install 
   ```

4. Access the services:
   
  - JOB Service: ```http://localhost:8081```
  - COMPANY Service: ```http://localhost:8082```
  - REVIEW Service: ```http://localhost:8083```
  - Eureka Dashboard: ```http://localhost:8761```
  - API Gateway: ```http://localhost:8084```

5. To run on Kubernetes, ensure Minikube is set up and deploy:

   ```bash
   kubectl apply -f k8s/
   ```

## Configuration
  - Configuration is managed via Spring Cloud Config Server.
  - The configuration is stored in a Git repository and mapped to the microservices.

## API Testing using Postman

![Screenshot 2024-09-14 073752](https://github.com/user-attachments/assets/3ab925fd-cdec-4be5-9762-0dc968041c82)

![Screenshot 2024-09-14 073812](https://github.com/user-attachments/assets/dd46da62-adea-49b3-b14a-d051aafe96fc)

![Screenshot 2024-09-14 073830](https://github.com/user-attachments/assets/102c9491-451c-40b7-a4fb-be04fce3b642)

### Example JSON response

```bash
[
    {
        "id": 1,
        "title": "Data Analytics",
        "description": "Analyze data to provide insights for business decisions.",
        "minSalary": "50000",
        "maxSalary": "90000",
        "location": "New York, NY",
        "company": {
            "id": 1,
            "name": "Google",
            "description": "Demo description for the company"
        },
        "reviews": [
            {
                "id": 1,
                "title": "Introduction to Programming",
                "description": "A beginner's course on programming fundamentals.",
                "rating": 4.5
            }
        ]
    },
    {
        "id": 2,
        "title": "Data Analytics",
        "description": "Analyze data to provide insights for business decisions.",
        "minSalary": "50000",
        "maxSalary": "90000",
        "location": "New York, NY",
        "company": {
            "id": 2,
            "name": "Google",
            "description": "Demo description for the company"
        },
        "reviews": []
    },
    {
        "id": 3,
        "title": "Data Analytics",
        "description": "Analyze data to provide insights for business decisions.",
        "minSalary": "50000",
        "maxSalary": "90000",
        "location": "New York, NY",
        "company": {
            "id": 2,
            "name": "Google",
            "description": "Demo description for the company"
        },
        "reviews": []
    },
    {
        "id": 4,
        "title": "Data Analytics",
        "description": "Analyze data to provide insights for business decisions.",
        "minSalary": "50000",
        "maxSalary": "90000",
        "location": "New York, NY",
        "company": {
            "id": 2,
            "name": "Google",
            "description": "Demo description for the company"
        },
        "reviews": []
    },
    {
        "id": 5,
        "title": "Data Analytics",
        "description": "Analyze data to provide insights for business decisions.",
        "minSalary": "50000",
        "maxSalary": "90000",
        "location": "New York, NY",
        "company": {
            "id": 3,
            "name": "Google",
            "description": "Demo description for the company"
        },
        "reviews": []
    },
    {
        "id": 6,
        "title": "Data Analytics",
        "description": "Analyze data to provide insights for business decisions.",
        "minSalary": "50000",
        "maxSalary": "90000",
        "location": "New York, NY",
        "company": {
            "id": 3,
            "name": "Google",
            "description": "Demo description for the company"
        },
        "reviews": []
    },
    {
        "id": 7,
        "title": "Data Analytics",
        "description": "Analyze data to provide insights for business decisions.",
        "minSalary": "50000",
        "maxSalary": "90000",
        "location": "New York, NY",
        "company": {
            "id": 1,
            "name": "Google",
            "description": "Demo description for the company"
        },
        "reviews": [
            {
                "id": 1,
                "title": "Introduction to Programming",
                "description": "A beginner's course on programming fundamentals.",
                "rating": 4.5
            }
        ]
    },
    {
        "id": 8,
        "title": "Data Analytics",
        "description": "Analyze data to provide insights for business decisions.",
        "minSalary": "50000",
        "maxSalary": "90000",
        "location": "New York, NY",
        "company": {
            "id": 1,
            "name": "Google",
            "description": "Demo description for the company"
        },
        "reviews": [
            {
                "id": 1,
                "title": "Introduction to Programming",
                "description": "A beginner's course on programming fundamentals.",
                "rating": 4.5
            }
        ]
    },
    {
        "id": 9,
        "title": "Data Analytics",
        "description": "Analyze data to provide insights for business decisions.",
        "minSalary": "50000",
        "maxSalary": "90000",
        "location": "New York, NY",
        "company": {
            "id": 1,
            "name": "Google",
            "description": "Demo description for the company"
        },
        "reviews": [
            {
                "id": 1,
                "title": "Introduction to Programming",
                "description": "A beginner's course on programming fundamentals.",
                "rating": 4.5
            }
        ]
    },
    {
        "id": 10,
        "title": "Data Analytics",
        "description": "Analyze data to provide insights for business decisions.",
        "minSalary": "50000",
        "maxSalary": "90000",
        "location": "New York, NY",
        "company": {
            "id": 1,
            "name": "Google",
            "description": "Demo description for the company"
        },
        "reviews": [
            {
                "id": 1,
                "title": "Introduction to Programming",
                "description": "A beginner's course on programming fundamentals.",
                "rating": 4.5
            }
        ]
    },
    {
        "id": 11,
        "title": "Data Analytics",
        "description": "Analyze data to provide insights for business decisions.",
        "minSalary": "50000",
        "maxSalary": "90000",
        "location": "New York, NY",
        "company": {
            "id": 1,
            "name": "Google",
            "description": "Demo description for the company"
        },
        "reviews": [
            {
                "id": 1,
                "title": "Introduction to Programming",
                "description": "A beginner's course on programming fundamentals.",
                "rating": 4.5
            }
        ]
    }
]
```

## Screenshots of Zipkin, pgAdmin database, Eureka Service registry

![zipkin](https://github.com/user-attachments/assets/023f9432-28ec-4775-808d-139f39221311)

![zipkin 2](https://github.com/user-attachments/assets/7bb94962-db76-4e14-82b6-15278df2925e)

![Screenshot 2024-09-14 074410](https://github.com/user-attachments/assets/6e7c0e2d-6841-4c27-85bc-972e02da3a29)

![Screenshot 2024-09-14 074509](https://github.com/user-attachments/assets/4c30682e-d278-4332-9c57-d6f41315a278)

![eureka ss](https://github.com/user-attachments/assets/ff75a305-f44f-4190-810b-ab03bbe8dd54)

