# 🛒 Flipkart-Like E-Commerce Microservices

[![CI/CD Pipeline](https://github.com/Abhish7899/flipkart-microservices/actions/workflows/ci-cd.yml/badge.svg)](https://github.com/Abhish7899/flipkart-microservices/actions/workflows/ci-cd.yml)
[![Kubernetes](https://img.shields.io/badge/Kubernetes-K3s%20on%20AWS-blue.svg)](https://k3s.io)
[![Live Demo](https://img.shields.io/badge/Live%20Demo-AWS%20EC2-brightgreen.svg)](http://18.221.209.92/)

### 🚀 Live Deployment Endpoints
* **🌐 Web Application:** [http://18.221.209.92/](http://18.221.209.92/)
* **⚡ API Gateway Products:** [http://18.221.209.92/api/products](http://18.221.209.92/api/products)
* **📊 Grafana Dashboard:** [http://18.221.209.92:3000](http://18.221.209.92:3000) (User: `admin` / Password: `FlipkartAdmin2026!`)
* **🔍 Eureka Service Registry:** [http://18.221.209.92/eureka/apps](http://18.221.209.92/eureka/apps)

---

## 🏗️ Architecture

```
                        ┌─────────────────────────────┐
                        │      React Frontend          │
                        │      (Port: 3000)            │
                        └─────────────┬───────────────┘
                                      │
                        ┌─────────────▼───────────────┐
                        │        API Gateway           │
                        │       (Port: 8080)           │
                        └──┬──────┬──────┬──────┬──────┘
                           │      │      │      │
               ┌───────────┘  ┌───┘  ┌───┘  ┌───┘
               ▼              ▼      ▼      ▼
        ┌──────────┐  ┌────────┐ ┌──────┐ ┌───────┐
        │  User    │  │Product │ │ Cart │ │ Order │
        │ :8081    │  │ :8082  │ │:8084 │ │ :8085 │
        └────┬─────┘  └───┬────┘ └──┬───┘ └───┬───┘
             │            │         │          │
        ┌────▼──────────────────────────────────▼────┐
        │              Apache Kafka                    │
        │  Topics: order-events, payment-events        │
        └────────┬───────────────────┬────────────────┘
                 ▼                   ▼
        ┌─────────────┐    ┌──────────────────┐
        │  Payment    │    │  Notification    │
        │   :8086     │    │     :8087        │
        └─────────────┘    └──────────────────┘
```

---

## 📦 Microservices

| Service | Port | Description | Database |
|---------|------|-------------|----------|
| **Service Registry** | 8761 | Eureka Discovery Server | - |
| **Config Server** | 8888 | Centralized Config | - |
| **API Gateway** | 8080 | Single entry point | - |
| **User Service** | 8081 | Auth, Registration, Profile | PostgreSQL (userdb) |
| **Product Service** | 8082 | Product catalog, search | PostgreSQL (productdb) |
| **Inventory Service** | 8083 | Stock management | PostgreSQL (inventorydb) |
| **Cart Service** | 8084 | Cart management | Redis |
| **Order Service** | 8085 | Order placement, tracking | PostgreSQL (orderdb) |
| **Payment Service** | 8086 | Payment processing | PostgreSQL (paymentdb) |
| **Notification Service** | 8087 | Email/SMS alerts | Kafka Consumer |
| **Review Service** | 8088 | Product reviews/ratings | PostgreSQL (reviewdb) |

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| **Backend** | Java 17 + Spring Boot 3.2 |
| **Service Discovery** | Netflix Eureka |
| **API Gateway** | Spring Cloud Gateway |
| **Security** | Spring Security + JWT |
| **Database** | PostgreSQL |
| **Cache** | Redis |
| **Messaging** | Apache Kafka |
| **Containerization** | Docker + Docker Compose |
| **Orchestration** | Kubernetes |
| **Frontend** | React.js |

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.8+
- Docker & Docker Compose
- PostgreSQL 15
- Redis 7
- Apache Kafka

### Option 1: Run with Docker (Recommended)

```bash
# Clone and start everything
docker-compose up --build
```

### Option 2: Run Locally (Step by Step)

```bash
# 1. Start Service Registry FIRST
cd service-registry
mvn spring-boot:run

# 2. Start Config Server
cd config-server
mvn spring-boot:run

# 3. Start API Gateway
cd api-gateway
mvn spring-boot:run

# 4. Start individual services
cd user-service && mvn spring-boot:run
cd product-service && mvn spring-boot:run
cd cart-service && mvn spring-boot:run
cd order-service && mvn spring-boot:run
cd payment-service && mvn spring-boot:run
cd notification-service && mvn spring-boot:run
```

---

## 📡 API Endpoints

### User Service (`/api/users`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/users/register` | Register new user |
| POST | `/api/users/login` | Login and get JWT |
| GET | `/api/users/{id}` | Get user profile |

### Product Service (`/api/products`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get product details |
| GET | `/api/products/search?keyword=` | Search products |
| GET | `/api/products/category/{cat}` | Filter by category |
| POST | `/api/products` | Add new product |

### Order Service (`/api/orders`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/orders` | Place new order |
| GET | `/api/orders/{id}` | Get order details |
| GET | `/api/orders/user/{userId}` | Get user orders |
| PUT | `/api/orders/{id}/cancel` | Cancel order |

### Cart Service (`/api/cart`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/cart/add` | Add item to cart |
| DELETE | `/api/cart/remove/{productId}` | Remove from cart |
| GET | `/api/cart/{userId}` | Get cart items |
| DELETE | `/api/cart/{userId}/clear` | Clear cart |

---

## 🗂️ Project Structure

```
flipkart-microservices/
├── 📄 pom.xml                    ← Root Maven POM
├── 📄 docker-compose.yml         ← Run everything with Docker
├── 📁 service-registry/          ← Eureka Server (Port 8761)
├── 📁 config-server/             ← Config Server (Port 8888)
├── 📁 api-gateway/               ← API Gateway (Port 8080)
├── 📁 user-service/              ← User + Auth (Port 8081)
├── 📁 product-service/           ← Products (Port 8082)
├── 📁 inventory-service/         ← Stock (Port 8083)
├── 📁 cart-service/              ← Cart (Port 8084)
├── 📁 order-service/             ← Orders (Port 8085)
├── 📁 payment-service/           ← Payments (Port 8086)
├── 📁 notification-service/      ← Notifications (Port 8087)
├── 📁 review-service/            ← Reviews (Port 8088)
├── 📁 frontend/                  ← React.js Frontend
├── 📁 docker/                    ← Dockerfiles
├── 📁 k8s/                       ← Kubernetes configs
└── 📁 docs/                      ← Documentation
```

---

## 🔑 Default Credentials

```
PostgreSQL:
  Username: flipkart
  Password: flipkart123

Eureka Dashboard: http://localhost:8761
API Gateway:       http://localhost:8080
```

---

## 📊 Kafka Topics

| Topic | Producer | Consumer |
|-------|---------|---------|
| `order-events` | Order Service | Inventory, Notification |
| `payment-events` | Payment Service | Order, Notification |
| `inventory-events` | Inventory Service | Order |

---

## 👨‍💻 Development Team

Built with ❤️ using Spring Boot Microservices
