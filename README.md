# Job Application Backend Project

This repository contains a backend application built for managing job applications using microservices architecture. The application is developed using **Spring Boot**, with multiple services such as **JOB**, **COMPANY**, and **REVIEW**. Each service operates independently with its own database. The project demonstrates a robust architecture with service registry, inter-service communication, fault tolerance, tracing, and containerization.

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
- **Fault Tolerance and Circuit Breaking**: 
  - Integrated **Resilience4J** for circuit breaking, retry mechanisms, and rate limiting.
  - Fall-back mechanisms in place to ensure service availability.
- **RabbitMQ Integration**: 
  - Message queue setup for publishing and consuming messages between services.
  - Real-time updates of company ratings using RabbitMQ queues.
- **Distributed Tracing**: 
  - **Zipkin** integration for tracing requests across services using Micrometer.
- **Configuration Management**: 
  - **Spring Cloud Config Server** is used to manage centralized configuration.
  - Mapped to a Git repository for version-controlled configurations.
- **Dockerization**: 
  - All microservices are containerized using Docker.
  - Multi-container setup using **Docker Compose**.
  - **Spring Boot Profiles** for development and production environments.
- **Kubernetes Deployment**:
  - Deployed on Kubernetes using **Minikube**.
  - Includes setup for **Pods**, **ReplicaSets**, and **Deployments**.

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
   
  JOB Service: ```http://localhost:8081```
   
  COMPANY Service: ```http://localhost:8082```
  
  REVIEW Service: ```http://localhost:8083```
  
  Eureka Dashboard: ```http://localhost:8761```
  
  API Gateway: ```http://localhost:8080```


5. To run on Kubernetes, ensure Minikube is set up and deploy:

   ```bash
   kubectl apply -f k8s/
   ```


## Configuration
  - Configuration is managed via Spring Cloud Config Server.
  - The configuration is stored in a Git repository and mapped to the microservices.

## Technologies Used
  - Spring Boot
  - Spring Cloud (Eureka, Config Server, API Gateway)
  - PostgreSQL (with Docker)
  - RabbitMQ
  - Zipkin (Distributed Tracing)
  - Resilience4J (Circuit Breaking)
  - Docker
  - Kubernetes


   
