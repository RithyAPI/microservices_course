🏦 Bank Microservices System
📌 Overview
This is a cloud-native microservices-based banking system built with Spring Boot and designed to run in a Kubernetes environment. It includes services for managing Accounts, Loans, and Cards, and is equipped with infrastructure tools like Config Server, Eureka, API Gateway, RabbitMQ, and Kafka.

🧩 Microservices
| Service           | Description                            | Database   |
| ----------------- | -------------------------------------- | ---------- |
| `account-service` | Manages customer accounts              | MongoDB    |
| `loan-service`    | Handles customer loan operations       | PostgreSQL |
| `card-service`    | Manages card issuance and transactions | PostgreSQL |


🛠️ Infrastructure Components
| Component           | Description                                       |
| ------------------- | ------------------------------------------------- |
| `config-server`     | Centralized configuration management              |
| `eureka-server`     | Service registry for discovery                    |
| `gateway-server`    | Routing and load balancing for microservices      |
| `RabbitMQ`          | Messaging for event-driven communication          |
| `Kafka`             | Event streaming platform for real-time data       |
| `Kubernetes + Helm` | Container orchestration and deployment templating |
