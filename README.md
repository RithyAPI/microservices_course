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

* Pre setup
JDK 17 
Maven 3.9.10
Docker Desktop

* How to run project
mvn clean install -DskipTests
mvn spring-boot:run

* How to build docker image
mvn compile jib:dockerBuild

* how to deploy on docker-compose
docker compose up -d --build

* How to deploy k8s
kubectl get service
kubectl get deployment
kubectl get pods
kubectl get configmap
kubectl get nodes
kubectl apply -f filename.yml
kubectl logs -f eurekaserver-deployment-6fcf996f86-pmhfk

* How to install helm
1. First you need to install choco
Reference: 
2. Second, install helm
3. Third, download existing helm chart from internet for testing
4. Four, Create own helm chart