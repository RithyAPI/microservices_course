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
