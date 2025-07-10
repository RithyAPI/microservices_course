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
kubectl get pvc
kubectl delete pvc _name
kubectl proxy

* How to install helm chart
https://helm.sh/docs/intro/quickstart/
helm repo add bitnami https://charts.bitnami.com/bitnami
helm search repo bitnami
helm repo update
helm install happy-penda bitnami/wordpress
helm uninstall happy-penda
help ls

Use port-forward:
kubectl port-forward svc/happy-penda-wordpress 8080:80
kubectl port-forward --namespace default svc/prometheus-kube-prometheus-prometheus 9090:9090

https://github.com/bitnami/charts


Start docker compose
docker compose up --pull always
# Core services
docker pull postgres:15
docker pull quay.io/keycloak/keycloak:23.0.4
docker pull mvertes/alpine-mongo:latest
docker pull nginx:latest

# Custom PisethBank images (you must have access to this registry)
docker pull pisethbank/configserver:v2
docker pull pisethbank/eurekaserver:v2
docker pull pisethbank/account:v2
docker pull pisethbank/card:v2
docker pull pisethbank/loan:v2
docker pull pisethbank/gatewayserver:v2

# Observability stack
docker pull grafana/loki:2.9.2
docker pull grafana/promtail:2.9.2
docker pull minio/minio
docker pull prom/prometheus:v2.45.0
docker pull grafana/tempo
docker pull grafana/grafana:latest
