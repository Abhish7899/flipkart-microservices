# ☁️ Flipkart Microservices - AWS Deployment Guide

This guide explains how to deploy the entire Flipkart microservices architecture to **Amazon Web Services (AWS)**.

---

## 🏗️ Architecture on AWS

```
                           [ Internet Users ]
                                  │
                                  ▼
               ┌──────────────────────────────────────┐
               │    AWS Application Load Balancer /   │
               │         Nginx Reverse Proxy          │
               │             (Port 80/443)            │
               └──────────────────┬───────────────────┘
                                  │
         ┌────────────────────────┼────────────────────────┐
         │                        │                        │
         ▼                        ▼                        ▼
 ┌───────────────┐       ┌─────────────────┐      ┌─────────────────┐
 │   UI Service  │       │   API Gateway   │      │ Service Registry│
 │  (Port 9090)  │       │   (Port 8080)   │      │  Eureka (8761)  │
 └───────────────┘       └────────┬────────┘      └─────────────────┘
                                  │
                  ┌───────────────┴───────────────┐
                  ▼                               ▼
         ┌─────────────────┐             ┌─────────────────┐
         │  User Service   │             │ Product Service │
         │   (Port 8081)   │             │   (Port 8082)   │
         └────────┬────────┘             └────────┬────────┘
                  │                               │
                  └───────────────┬───────────────┘
                                  ▼
                      ┌───────────────────────┐
                      │ PostgreSQL / AWS RDS  │
                      │      (Port 5432)      │
                      └───────────────────────┘
```

---

## 🚀 Option 1: Fast 1-Click Deployment on AWS EC2 (Recommended)

This is the most cost-effective and easiest method (runs on AWS Free Tier or a **t3.small / t3.medium** instance).

### Step 1: Launch an AWS EC2 Instance
1. Log in to your [AWS Management Console](https://console.aws.amazon.com/ec2/).
2. Click **Launch Instances**:
   - **Name**: `flipkart-microservices`
   - **AMI**: `Ubuntu Server 22.04 LTS (HVM), SSD Volume Type`
   - **Instance Type**: `t3.small` (2 vCPU, 2 GB RAM) or `t3.medium` (4 GB RAM recommended for multi-service builds)
   - **Key Pair**: Select or create a new `.pem` key pair (e.g. `flipkart-key.pem`)
   - **Storage**: Minimum `25 GB` gp3 root disk

### Step 2: Configure Security Group (Firewall Rules)
In **Network Settings**, allow the following **Inbound Rules**:

| Type | Port Range | Source | Description |
|---|---|---|---|
| **SSH** | `22` | `My IP` or `0.0.0.0/0` | Remote Terminal Access |
| **HTTP** | `80` | `0.0.0.0/0` | Public Website Access |
| **HTTPS** | `443` | `0.0.0.0/0` | Secure SSL Traffic |
| **Custom TCP** | `8761` | `0.0.0.0/0` | Eureka Dashboard |
| **Custom TCP** | `9090` | `0.0.0.0/0` | Direct UI Service Port |
| **Custom TCP** | `8080` | `0.0.0.0/0` | API Gateway Port |

Click **Launch Instance**.

---

### Step 3: Connect via SSH & Deploy with 1 Command

1. Open your terminal / PowerShell on your PC and connect to your EC2 instance:
```bash
ssh -i "flipkart-key.pem" ubuntu@<YOUR_EC2_PUBLIC_IP>
```

2. Clone your repository or upload your project files:
```bash
git clone <YOUR_REPOSITORY_URL> flipkart-app
cd flipkart-app
```

3. Make the deployment script executable and run it:
```bash
chmod +x deploy-aws.sh
./deploy-aws.sh
```

**What the script does automatically:**
- Installs Docker & Docker Compose
- Configures environment and security settings
- Builds all multi-stage Docker containers with optimized JVM memory
- Launches Nginx reverse proxy, Eureka, User Service, Product Service, and UI
- Initializes database tables and seeds products

4. Once finished, open your browser and visit:
👉 **`http://<YOUR_EC2_PUBLIC_IP>`** (runs on port 80 directly!)

---

## 🏢 Option 2: Enterprise Deployment on AWS EKS (Kubernetes)

If you are using **AWS Elastic Kubernetes Service (EKS)**:

### 1. Build and Push Images to Amazon ECR (Elastic Container Registry)
```bash
# Login to AWS ECR
aws ecr get-login-password --region <AWS_REGION> | docker login --username AWS --password-stdin <AWS_ACCOUNT_ID>.dkr.ecr.<AWS_REGION>.amazonaws.com

# Build & tag images
docker build -t <AWS_ACCOUNT_ID>.dkr.ecr.<AWS_REGION>.amazonaws.com/flipkart-eureka:latest ./service-registry
docker build -t <AWS_ACCOUNT_ID>.dkr.ecr.<AWS_REGION>.amazonaws.com/flipkart-gateway:latest ./api-gateway
docker build -t <AWS_ACCOUNT_ID>.dkr.ecr.<AWS_REGION>.amazonaws.com/flipkart-user-service:latest ./user-service
docker build -t <AWS_ACCOUNT_ID>.dkr.ecr.<AWS_REGION>.amazonaws.com/flipkart-product-service:latest ./product-service
docker build -t <AWS_ACCOUNT_ID>.dkr.ecr.<AWS_REGION>.amazonaws.com/flipkart-ui:latest ./ui-service

# Push to ECR
docker push <AWS_ACCOUNT_ID>.dkr.ecr.<AWS_REGION>.amazonaws.com/flipkart-eureka:latest
docker push <AWS_ACCOUNT_ID>.dkr.ecr.<AWS_REGION>.amazonaws.com/flipkart-gateway:latest
docker push <AWS_ACCOUNT_ID>.dkr.ecr.<AWS_REGION>.amazonaws.com/flipkart-user-service:latest
docker push <AWS_ACCOUNT_ID>.dkr.ecr.<AWS_REGION>.amazonaws.com/flipkart-product-service:latest
docker push <AWS_ACCOUNT_ID>.dkr.ecr.<AWS_REGION>.amazonaws.com/flipkart-ui:latest
```

### 2. Deploy Manifests to EKS Cluster
```bash
# 1. Create Namespace
kubectl apply -f k8s/namespace.yaml

# 2. Deploy Microservices
kubectl apply -f k8s/deployments/flipkart-microservices.yaml

# 3. Create ClusterIP Services
kubectl apply -f k8s/services/flipkart-services.yaml

# 4. Deploy AWS Application Load Balancer Ingress
kubectl apply -f k8s/ingress.yaml
```

---

## 🗄️ Option 3: Connecting to Managed AWS RDS (PostgreSQL)

To use AWS RDS instead of a containerized database:

1. Launch an **Amazon RDS PostgreSQL** instance in your VPC.
2. In `docker-compose.aws.yml`, update the environment variables:
```yaml
user-service:
  environment:
    SPRING_DATASOURCE_URL: jdbc:postgresql://<YOUR_RDS_ENDPOINT>:5432/userdb
    SPRING_DATASOURCE_USERNAME: <YOUR_RDS_USERNAME>
    SPRING_DATASOURCE_PASSWORD: <YOUR_RDS_PASSWORD>

product-service:
  environment:
    SPRING_DATASOURCE_URL: jdbc:postgresql://<YOUR_RDS_ENDPOINT>:5432/productdb
    SPRING_DATASOURCE_USERNAME: <YOUR_RDS_USERNAME>
    SPRING_DATASOURCE_PASSWORD: <YOUR_RDS_PASSWORD>
```

---

## 🔒 Custom Domain & Free SSL (HTTPS) on EC2

To attach a domain (e.g. `flipkart.yourdomain.com`) with a free SSL certificate:

1. Point your domain's DNS **A Record** to your **EC2 Public IP**.
2. On your EC2 terminal, install Certbot:
```bash
sudo apt-get install -y certbot python3-certbot-nginx
sudo certbot --nginx -d yourdomain.com -d www.yourdomain.com
```
Certbot will automatically configure HTTPS on port 443 with auto-renewal!

---

## 🛠️ Management & Monitoring Commands on AWS

```bash
# Check running containers
docker compose -f docker-compose.aws.yml ps

# View live logs of a specific service
docker compose -f docker-compose.aws.yml logs -f product-service
docker compose -f docker-compose.aws.yml logs -f ui-service

# Restart the entire stack
docker compose -f docker-compose.aws.yml restart

# Stop all containers
docker compose -f docker-compose.aws.yml down
```
